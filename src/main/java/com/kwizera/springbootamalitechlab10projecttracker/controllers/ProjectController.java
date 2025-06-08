package com.kwizera.springbootamalitechlab10projecttracker.controllers;

import com.kwizera.springbootamalitechlab10projecttracker.domain.dtos.CreateProjectRequestDTO;
import com.kwizera.springbootamalitechlab10projecttracker.domain.dtos.ProjectDTO;
import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Developer;
import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Project;
import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Task;
import com.kwizera.springbootamalitechlab10projecttracker.domain.mappers.EntityToDTO;
import com.kwizera.springbootamalitechlab10projecttracker.services.AuditLogServices;
import com.kwizera.springbootamalitechlab10projecttracker.services.DeveloperServices;
import com.kwizera.springbootamalitechlab10projecttracker.services.ProjectServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {
    private final DeveloperServices developerServices;
    private final ProjectServices projectServices;
    private final AuditLogServices auditLogServices;

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProjects(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Project> projectPage = projectServices.getAllProjects(page, size);
        List<ProjectDTO> projects = projectPage.stream()
                .map(EntityToDTO::projectEntityToDTO)
                .toList();

        auditLogServices.log(
                "Retrieve",
                "Project",
                "N/A",
                "admin",
                Map.of(
                        "pageNumber", page,
                        "pageSize", size,
                        "resultsCount", projects.size()
                )
        );

        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@Valid @RequestBody CreateProjectRequestDTO projectDetails) {
        List<Developer> developers = projectDetails
                .developers()
                .stream()
                .map(developerServices::getDeveloper)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();

        Project newProject = Project.builder()
                .name(projectDetails.name())
                .description(projectDetails.description())
                .developers(developers)
                .deadline(LocalDate.parse(projectDetails.deadline()))
                .build();

        List<Task> tasks = projectDetails.tasks()
                .stream()
                .map(task -> {
                    return Task.builder()
                            .title(task.title())
                            .description(task.description())
                            .project(newProject)
                            .dueDate(LocalDate.parse(task.deadline()))
                            .build();
                }).toList();

        newProject.setTasks(tasks);

        Project createdProject = projectServices.createProject(newProject);

        auditLogServices.log(
                "Create",
                "Project",
                createdProject.getId().toString(),
                "admin",
                Map.of(
                        "projectName", createdProject.getName(),
                        "projectDesc", createdProject.getDescription(),
                        "projectDeadline", createdProject.getDeadline()
                )
        );

        return new ResponseEntity<>(EntityToDTO.projectEntityToDTO(createdProject), HttpStatus.CREATED);
    }
}
