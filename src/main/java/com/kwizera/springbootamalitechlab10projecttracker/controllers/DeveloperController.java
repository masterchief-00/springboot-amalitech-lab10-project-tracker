package com.kwizera.springbootamalitechlab10projecttracker.controllers;

import com.kwizera.springbootamalitechlab10projecttracker.domain.dtos.CreateDeveloperRequestDTO;
import com.kwizera.springbootamalitechlab10projecttracker.domain.dtos.DeveloperDTO;
import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Developer;
import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Skill;
import com.kwizera.springbootamalitechlab10projecttracker.services.DeveloperServices;
import com.kwizera.springbootamalitechlab10projecttracker.services.SkillServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/developers")
public class DeveloperController {
    private final SkillServices skillServices;
    private final DeveloperServices developerServices;

    @PostMapping
    public ResponseEntity<DeveloperDTO> createDev(@Valid @RequestBody CreateDeveloperRequestDTO developerDetails) {
        Set<Skill> skillSet = developerDetails.skills()
                .stream()
                .map(s -> skillServices
                        .createSkill(s.trim()))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        Developer developer = Developer.builder()
                .firstName(developerDetails.firstName())
                .lastName(developerDetails.lastName())
                .email(developerDetails.email())
                .skills(skillSet)
                .build();

        Developer createdDeveloper = developerServices.registerDeveloper(developer);

        DeveloperDTO developerDTO = DeveloperDTO.builder()
                .names(createdDeveloper.getFirstName() + " " + createdDeveloper.getLastName())
                .email(createdDeveloper.getEmail())
                .skills(createdDeveloper.getSkills().stream().map(Skill::getName).toList())
                .build();
        return new ResponseEntity<>(developerDTO, HttpStatus.CREATED);
    }
}
