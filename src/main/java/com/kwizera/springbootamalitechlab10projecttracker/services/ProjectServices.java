package com.kwizera.springbootamalitechlab10projecttracker.services;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Project;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectServices {
    Optional<Project> getProject(UUID id);

    Page<Project> getAllProjects();

    Project updateProject(UUID id, Project project);

    Project createProject(Project project);

    void deleteProject(UUID id);
}
