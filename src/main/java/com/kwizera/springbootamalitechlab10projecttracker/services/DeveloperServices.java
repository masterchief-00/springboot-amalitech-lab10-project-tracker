package com.kwizera.springbootamalitechlab10projecttracker.services;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Developer;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface DeveloperServices {
    Optional<Developer> getDeveloper(UUID id);

    Page<Developer> getAllDevelopers(int page, int size);

    Developer registerDeveloper(Developer developer);

    Developer updateDeveloper(UUID id, Developer developer);

    void deleteDeveloper(UUID id);
}
