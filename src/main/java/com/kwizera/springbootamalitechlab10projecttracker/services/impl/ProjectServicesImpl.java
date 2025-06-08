package com.kwizera.springbootamalitechlab10projecttracker.services.impl;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Project;
import com.kwizera.springbootamalitechlab10projecttracker.repositories.ProjectRepository;
import com.kwizera.springbootamalitechlab10projecttracker.services.ProjectServices;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectServicesImpl implements ProjectServices {
    private final ProjectRepository projectRepository;

    @Override
    public Optional<Project> getProject(UUID id) {
        return Optional.empty();
    }

    @Override
    public Page<Project> getAllProjects(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return projectRepository.findAll(pageable);
    }

    @Override
    public Project updateProject(UUID id, Project project) {
        return null;
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(UUID id) {

    }
}
