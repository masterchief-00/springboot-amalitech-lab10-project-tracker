package com.kwizera.springbootamalitechlab10projecttracker.services.impl;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Skill;
import com.kwizera.springbootamalitechlab10projecttracker.services.SkillServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SkillServicesImpl implements SkillServices {
    @Override
    public List<Skill> getAllSkills() {
        return null;
    }

    @Override
    public Skill createSkill(Skill skill) {
        return null;
    }

    @Override
    public Skill updateSkill(UUID id, Skill skill) {
        return null;
    }

    @Override
    public void deleteSkill(UUID id) {

    }
}
