package com.kwizera.springbootamalitechlab10projecttracker.services.impl;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Task;
import com.kwizera.springbootamalitechlab10projecttracker.services.TaskServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskServicesImpl implements TaskServices {
    @Override
    public List<Task> getTasksByProject(UUID projectId) {
        return null;
    }

    @Override
    public Optional<Task> getTask(UUID id) {
        return Optional.empty();
    }

    @Override
    public Task createTask(Task task) {
        return null;
    }

    @Override
    public Task updateTask(UUID id, Task task) {
        return null;
    }

    @Override
    public void deleteTask(UUID id) {

    }
}
