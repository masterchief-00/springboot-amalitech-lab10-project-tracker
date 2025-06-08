package com.kwizera.springbootamalitechlab10projecttracker.services;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Project;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectServices {
    Optional<Project> getProject(UUID id);

    List<Project> getAllProjects();

    Project updateProject(UUID id, Project project);

    Project createProject(Project project);

    void deleteProject(UUID id);
}
