package com.kwizera.springbootamalitechlab10projecttracker.services.impl;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Project;
import com.kwizera.springbootamalitechlab10projecttracker.services.ProjectServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectServicesImpl implements ProjectServices {
    @Override
    public Optional<Project> getProject(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<Project> getAllProjects() {
        return null;
    }

    @Override
    public Project updateProject(UUID id, Project project) {
        return null;
    }

    @Override
    public Project createProject(Project project) {
        return null;
    }

    @Override
    public void deleteProject(UUID id) {

    }
}
