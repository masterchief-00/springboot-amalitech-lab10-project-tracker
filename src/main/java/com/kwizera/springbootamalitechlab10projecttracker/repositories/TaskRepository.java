package com.kwizera.springbootamalitechlab10projecttracker.repositories;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    Page<Task> findByProjectId(UUID projectId, Pageable pageable);
}
