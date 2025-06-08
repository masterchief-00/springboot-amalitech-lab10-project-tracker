package com.kwizera.springbootamalitechlab10projecttracker.domain.dtos;

import com.kwizera.springbootamalitechlab10projecttracker.domain.enums.StatusEnum;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Builder
public record ProjectDTO(
        UUID id,
        String name,
        String description,
        StatusEnum status,
        LocalDate deadline,
        List<DeveloperDTO> developers,
        List<TaskDTO> tasks
) {
}
