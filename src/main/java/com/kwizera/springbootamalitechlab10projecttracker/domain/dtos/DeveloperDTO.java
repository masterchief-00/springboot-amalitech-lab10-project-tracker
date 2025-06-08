package com.kwizera.springbootamalitechlab10projecttracker.domain.dtos;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Skill;
import lombok.Builder;

import java.util.List;
import java.util.Optional;

@Builder
public record DeveloperDTO(
        String names,
        String email,
        Optional<String> project,
        List<String> skills
) {
}
