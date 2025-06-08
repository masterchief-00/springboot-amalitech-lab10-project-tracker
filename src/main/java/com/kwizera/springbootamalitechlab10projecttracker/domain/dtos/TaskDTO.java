package com.kwizera.springbootamalitechlab10projecttracker.domain.dtos;

import com.kwizera.springbootamalitechlab10projecttracker.domain.enums.StatusEnum;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record TaskDTO(
        String title,
        String description,
        StatusEnum status,
        LocalDate deadline
        ) {
}
