package com.kwizera.springbootamalitechlab10projecttracker.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public record CreateProjectRequestDTO(
        @Pattern(regexp = "^[A-Za-z0-9 ]{2,50}$", message = "Name must contain only alphanumeric characters")
        @NotBlank(message = "Project name is required")
        String name,

        @Size(max = 150)
        @NotBlank(message = "Project description is required")
        String description,

        @Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$", message = "Invalid date")
        @NotBlank(message = "Deadline date is required")
        String deadline,

        @Size(min = 1, message = "At least one developer needs to be assigned")
        Set<UUID> developers,

        @Size(min = 1, message = "A project must have at list one task")
        Set<TaskCreateDTO> tasks
) {
}
