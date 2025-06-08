package com.kwizera.springbootamalitechlab10projecttracker.domain.mappers;

import com.kwizera.springbootamalitechlab10projecttracker.domain.dtos.DeveloperDTO;
import com.kwizera.springbootamalitechlab10projecttracker.domain.dtos.TaskDTO;
import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Developer;
import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Project;
import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Skill;
import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Task;

import java.util.Optional;

public class EntityToDTO {
    public static DeveloperDTO developerEntityToDTO(Developer developerEntity) {
        return DeveloperDTO.builder()
                .id(developerEntity.getId())
                .names(developerEntity.getFirstName() + " " + developerEntity.getLastName())
                .email(developerEntity.getEmail())
                .project(Optional.ofNullable(developerEntity.getProject()).map(Project::getName).orElse("none"))
                .skills(developerEntity.getSkills().stream().map(Skill::getName).toList())
                .build();
    }

    public static TaskDTO taskEntityToDTO(Task taskEntity) {
        return TaskDTO.builder()
                .title(taskEntity.getTitle())
                .description(taskEntity.getDescription())
                .status(taskEntity.getStatus())
                .deadline(taskEntity.getDueDate())
                .build();
    }
}
