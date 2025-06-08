package com.kwizera.springbootamalitechlab10projecttracker.services;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Skill;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SkillServices {
    List<Skill> getAllSkills();

    Optional<Skill> getSkillByName(String skill);

    Skill createSkill(String skill);

    Skill updateSkill(UUID id, Skill skill);

    void deleteSkill(UUID id);
}
