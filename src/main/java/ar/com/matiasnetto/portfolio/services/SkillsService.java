package ar.com.matiasnetto.portfolio.services;

import ar.com.matiasnetto.portfolio.dto.SkillsInDTO;
import ar.com.matiasnetto.portfolio.mappers.SkillsInDTOToSkills;
import ar.com.matiasnetto.portfolio.models.Skills;
import ar.com.matiasnetto.portfolio.repository.SkillsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsService {
    private final SkillsRepository repository;
    private final SkillsInDTOToSkills mapper;

    public SkillsService(SkillsRepository repository, SkillsInDTOToSkills mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Skills> getAllSkills() {
        return this.repository.findAll();
    }

    public Skills createNewSkill(SkillsInDTO skillDTO) {
        return  this.repository.save(this.mapper.map(skillDTO));
    }


}
