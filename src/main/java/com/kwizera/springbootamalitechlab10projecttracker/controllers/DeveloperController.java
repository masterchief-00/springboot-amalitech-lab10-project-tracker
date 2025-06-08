package com.kwizera.springbootamalitechlab10projecttracker.controllers;

import com.kwizera.springbootamalitechlab10projecttracker.domain.dtos.CreateDeveloperRequestDTO;
import com.kwizera.springbootamalitechlab10projecttracker.domain.dtos.DeveloperDTO;
import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Developer;
import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Skill;
import com.kwizera.springbootamalitechlab10projecttracker.domain.mappers.EntityToDTO;
import com.kwizera.springbootamalitechlab10projecttracker.services.DeveloperServices;
import com.kwizera.springbootamalitechlab10projecttracker.services.SkillServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/developers")
public class DeveloperController {
    private final SkillServices skillServices;
    private final DeveloperServices developerServices;

    @GetMapping
    public ResponseEntity<List<DeveloperDTO>> getDevelopers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Developer> developerPage = developerServices.getAllDevelopers(page, size);
        List<DeveloperDTO> developers = developerPage.stream()
                .map(EntityToDTO::developerEntityToDTO)
                .toList();
        return new ResponseEntity<>(developers, HttpStatus.OK);
    }

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

        return new ResponseEntity<>(EntityToDTO.developerEntityToDTO(createdDeveloper), HttpStatus.CREATED);
    }
}
