package com.kwizera.springbootamalitechlab10projecttracker.services.impl;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Developer;
import com.kwizera.springbootamalitechlab10projecttracker.services.DeveloperServices;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeveloperServicesImpl implements DeveloperServices {
    @Override
    public Optional<Developer> getDeveloper(UUID id) {
        return Optional.empty();
    }

    @Override
    public Developer registerDeveloper(Developer developer) {
        return null;
    }

    @Override
    public Developer updateDeveloper(UUID id, Developer developer) {
        return null;
    }

    @Override
    public void deleteDeveloper(UUID id) {

    }
}
