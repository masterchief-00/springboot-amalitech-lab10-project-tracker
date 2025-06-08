package com.kwizera.springbootamalitechlab10projecttracker.domain.dtos;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Skill;
import lombok.Builder;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Builder
public record DeveloperDTO(
        UUID id,
        String names,
        String email,
        String project,
        List<String> skills
) {
}
