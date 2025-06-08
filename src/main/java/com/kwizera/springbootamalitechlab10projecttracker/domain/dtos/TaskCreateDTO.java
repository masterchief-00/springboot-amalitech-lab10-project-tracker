package com.kwizera.springbootamalitechlab10projecttracker.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record TaskCreateDTO(
        @Pattern(regexp = "^[A-Za-z0-9 ]{2,50}$", message = "Task title must contain only alphanumeric characters")
        @NotBlank(message = "Task title is required")
        String title,

        @Size(max = 150)
        @NotBlank(message = "Title description is required")
        String description,

        @Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$", message = "Invalid date")
        @NotBlank(message = "Deadline date is required")
        String deadline
) {
}
