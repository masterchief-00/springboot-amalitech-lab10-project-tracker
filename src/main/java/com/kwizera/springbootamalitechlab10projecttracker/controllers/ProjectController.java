package com.kwizera.springbootamalitechlab10projecttracker.controllers;

import com.kwizera.springbootamalitechlab10projecttracker.domain.dtos.CreateProjectRequestDTO;
import com.kwizera.springbootamalitechlab10projecttracker.domain.dtos.ProjectDTO;
import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Developer;
import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Project;
import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Task;
import com.kwizera.springbootamalitechlab10projecttracker.domain.mappers.EntityToDTO;
import com.kwizera.springbootamalitechlab10projecttracker.services.DeveloperServices;
import com.kwizera.springbootamalitechlab10projecttracker.services.ProjectServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {
    private final DeveloperServices developerServices;
    private final ProjectServices projectServices;

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

        ProjectDTO projectDTO = ProjectDTO.builder()
                .name(createdProject.getName())
                .description(createdProject.getDescription())
                .status(createdProject.getStatus())
                .deadline(createdProject.getDeadline())
                .developers(createdProject.getDevelopers().stream().map(EntityToDTO::developerEntityToDTO).toList())
                .tasks(createdProject.getTasks().stream().map(EntityToDTO::taskEntityToDTO).toList())
                .build();

        return new ResponseEntity<>(projectDTO, HttpStatus.CREATED);
    }
}
