package com.kwizera.springbootamalitechlab10projecttracker.services;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskServices {
    List<Task> getTasksByProject(UUID projectId);

    Optional<Task> getTask(UUID id);

    Task createTask(Task task);

    Task updateTask(UUID id, Task task);

    void deleteTask(UUID id);
}
