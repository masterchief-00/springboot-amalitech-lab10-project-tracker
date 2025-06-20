package com.kwizera.springbootamalitechlab10projecttracker.repositories;

import com.kwizera.springbootamalitechlab10projecttracker.domain.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SkillRepository extends JpaRepository<Skill, UUID> {
    Optional<Skill> findByNameIgnoreCase(String skillName);
}
