package com.kwizera.springbootamalitechlab10projecttracker.services.impl;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Developer;
import com.kwizera.springbootamalitechlab10projecttracker.repositories.DeveloperRepository;
import com.kwizera.springbootamalitechlab10projecttracker.services.DeveloperServices;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeveloperServicesImpl implements DeveloperServices {
    private final DeveloperRepository developerRepository;

    @Override
    public Optional<Developer> getDeveloper(UUID id) {
        return developerRepository.findById(id);
    }

    @Cacheable("developers")
    @Override
    public Page<Developer> getAllDevelopers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return developerRepository.findAll(pageable);
    }

    @Override
    public Developer registerDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    public Developer updateDeveloper(UUID id, Developer developer) {
        return null;
    }

    @Override
    public void deleteDeveloper(UUID id) {

    }
}
