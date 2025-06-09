package com.kwizera.springbootamalitechlab10projecttracker.controllers;

import com.kwizera.springbootamalitechlab10projecttracker.domain.dtos.TaskDTO;
import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Task;
import com.kwizera.springbootamalitechlab10projecttracker.domain.mappers.EntityToDTO;
import com.kwizera.springbootamalitechlab10projecttracker.services.AuditLogServices;
import com.kwizera.springbootamalitechlab10projecttracker.services.TaskServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
@Tag(name = "Task Controller", description = "This controller exposes endpoints for all CRUD operations regarding tasks")
public class TaskController {
    private final TaskServices taskServices;
    private final AuditLogServices auditLogServices;

    @Operation(summary = "Retrieves all tasks of a project (with pagination)")
    @GetMapping(path = "/project/{projectId}")
    public ResponseEntity<List<TaskDTO>> getSortedTasksByProject(@PathVariable UUID projectId, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "createdAt") String sortBy) {
        Page<Task> taskPage = taskServices.getTasksByProject(page, size, projectId, sortBy);
        List<TaskDTO> tasks = taskPage.stream()
                .map(EntityToDTO::taskEntityToDTO)
                .toList();

        auditLogServices.log(
                "Retrieve",
                "Task",
                "N/A",
                "admin",
                Map.of(
                        "pageNumber", page,
                        "pageSize", size,
                        "sort", sortBy,
                        "resultsCount", tasks.size()
                )
        );

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
