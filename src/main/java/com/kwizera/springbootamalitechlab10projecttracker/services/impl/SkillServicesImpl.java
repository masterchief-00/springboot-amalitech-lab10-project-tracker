package com.kwizera.springbootamalitechlab10projecttracker.services.impl;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Skill;
import com.kwizera.springbootamalitechlab10projecttracker.repositories.SkillRepository;
import com.kwizera.springbootamalitechlab10projecttracker.services.SkillServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SkillServicesImpl implements SkillServices {
    private final SkillRepository skillRepository;

    @Override
    public List<Skill> getAllSkills() {
        return null;
    }

    @Override
    public Optional<Skill> getSkillByName(String skill) {
        return skillRepository.findByNameIgnoreCase(skill);
    }

    @Override
    public Skill createSkill(String skill) {
        Optional<Skill> skillFound = getSkillByName(skill);

        if (skillFound.isEmpty()) {
            Skill newSkill = Skill.builder().name(skill).build();
            return skillRepository.save(newSkill);
        } else {
            return skillFound.get();
        }
    }

    @Override
    public Skill updateSkill(UUID id, Skill skill) {
        return null;
    }

    @Override
    public void deleteSkill(UUID id) {

    }


}
