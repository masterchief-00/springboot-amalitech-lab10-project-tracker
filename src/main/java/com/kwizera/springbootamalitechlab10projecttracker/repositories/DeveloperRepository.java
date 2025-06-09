package com.kwizera.springbootamalitechlab10projecttracker.repositories;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Developer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeveloperRepository extends JpaRepository<Developer, UUID> {
    Optional<Developer> findById(UUID id);

    Page<Developer> findAll(Pageable pageable);
}
