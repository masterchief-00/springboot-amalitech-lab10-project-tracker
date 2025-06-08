package com.kwizera.springbootamalitechlab10projecttracker.repositories;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
}
