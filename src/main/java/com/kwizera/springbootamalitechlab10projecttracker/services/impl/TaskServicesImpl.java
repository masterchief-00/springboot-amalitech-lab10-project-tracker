package com.kwizera.springbootamalitechlab10projecttracker.services.impl;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Task;
import com.kwizera.springbootamalitechlab10projecttracker.repositories.TaskRepository;
import com.kwizera.springbootamalitechlab10projecttracker.services.TaskServices;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskServicesImpl implements TaskServices {
    private final TaskRepository taskRepository;

    @Override
    public Page<Task> getTasksByProject(int page, int size, UUID projectId, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
        return taskRepository.findByProjectId(projectId, pageable);
    }

    @Override
    public Optional<Task> getTask(UUID id) {
        return Optional.empty();
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(UUID id, Task task) {
        return null;
    }

    @Override
    public void deleteTask(UUID id) {

    }
}
