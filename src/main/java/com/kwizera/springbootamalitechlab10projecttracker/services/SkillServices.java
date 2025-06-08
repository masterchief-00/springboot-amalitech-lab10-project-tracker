package com.kwizera.springbootamalitechlab10projecttracker.services;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Skill;

import java.util.List;
import java.util.UUID;

public interface SkillServices {
    List<Skill> getAllSkills();

    Skill createSkill(Skill skill);

    Skill updateSkill(UUID id, Skill skill);

    void deleteSkill(UUID id);
}
