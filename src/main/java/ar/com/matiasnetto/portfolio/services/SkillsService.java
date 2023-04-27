package ar.com.matiasnetto.portfolio.services;

import ar.com.matiasnetto.portfolio.dto.SkillsInDTO;
import ar.com.matiasnetto.portfolio.exceptions.ResourceNotFoundException;
import ar.com.matiasnetto.portfolio.mappers.SkillsInDTOToSkills;
import ar.com.matiasnetto.portfolio.models.Skills;
import ar.com.matiasnetto.portfolio.repository.SkillsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Skills updateSkill(SkillsInDTO newData, int id) {
        Optional<Skills> mySkillOpt = this.repository.findById(id);

        if (mySkillOpt.isEmpty()) {
           throw new ResourceNotFoundException("Skill", "id", String.valueOf(id));
        }

        Skills mySkill = mySkillOpt.get();
        mySkill.setTechnology(newData.getTechnology());
        mySkill.setPercent(newData.getPercent());
        mySkill.setOrd(newData.getOrd());
        mySkill.setImage_url(newData.getImage_url());

        return this.repository.save(mySkill);
    }

}
