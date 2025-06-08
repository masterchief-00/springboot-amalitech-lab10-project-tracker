package com.kwizera.springbootamalitechlab10projecttracker.domain.dtos;

import jakarta.validation.constraints.*;
import java.util.Set;

public record CreateDeveloperRequestDTO(
        @Pattern(regexp = "^[A-Za-z ]{2,50}$", message = "Name must contain only letters and spaces")
        @NotBlank(message = "First name is required")
        String firstName,
        @Pattern(regexp = "^[A-Za-z ]{2,50}$", message = "Name must contain only letters and spaces")
        @NotBlank(message = "Last name is required")
        String lastName,

        @NotNull(message = "Email is required")
        @Email(message = "Invalid email")
        String email,
        @Size(min = 1, message = "Minimum of {min} skill(s) is required")
        Set<@NotBlank(message = "Invalid skill provided") String> skills
) {
}
