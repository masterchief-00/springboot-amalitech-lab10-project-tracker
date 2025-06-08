package com.kwizera.springbootamalitechlab10projecttracker.repositories;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeveloperRepository extends JpaRepository<Developer, UUID> {
}
