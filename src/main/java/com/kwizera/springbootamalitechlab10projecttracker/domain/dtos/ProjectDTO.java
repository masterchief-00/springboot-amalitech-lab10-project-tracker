package com.kwizera.springbootamalitechlab10projecttracker.domain.dtos;

import com.kwizera.springbootamalitechlab10projecttracker.domain.enums.StatusEnum;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record ProjectDTO(
        String name,
        String description,
        StatusEnum status,
        LocalDate deadline,
        List<DeveloperDTO> developers,
        List<TaskDTO> tasks
) {
}
