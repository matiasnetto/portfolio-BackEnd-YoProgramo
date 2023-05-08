package ar.com.matiasnetto.portfolio.services;

import ar.com.matiasnetto.portfolio.dto.SkillsInDTO;
import ar.com.matiasnetto.portfolio.exceptions.ResourceNotFoundException;
import ar.com.matiasnetto.portfolio.mappers.SkillsInDTOToSkills;
import ar.com.matiasnetto.portfolio.models.Skills;
import ar.com.matiasnetto.portfolio.repository.ProjectsRepository;
import ar.com.matiasnetto.portfolio.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillsService {
    @Autowired
    SkillsRepository skillsRepository;
    @Autowired
    ProjectsRepository projectsRepository;
    @Autowired
   SkillsInDTOToSkills mapper;

    public List<Skills> getAllSkills() {
        return this.skillsRepository.findAll();
    }

    public Skills getSkillById(int id) {
        Optional<Skills> optSkill = this.skillsRepository.findById(id);

        if (optSkill.isEmpty()) {throw new ResourceNotFoundException("Skill", "id", String.valueOf(id));}

        return optSkill.get();
    }


    public Skills createNewSkill(SkillsInDTO skillDTO) {
        return  this.skillsRepository.save(this.mapper.map(skillDTO));
    }

    public Skills updateSkill(SkillsInDTO newData, int id) {
        Optional<Skills> mySkillOpt = this.skillsRepository.findById(id);

        if (mySkillOpt.isEmpty()) {
           throw new ResourceNotFoundException("Skill", "id", String.valueOf(id));
        }

        Skills mySkill = mySkillOpt.get();
        mySkill.setTechnology(newData.getTechnology());
        mySkill.setPercent(newData.getPercent());
        mySkill.setOrd(newData.getOrd());
        mySkill.setImage_url(newData.getImage_url());

        return this.skillsRepository.save(mySkill);
    }

    public Skills deleteSkill(int id) {
        Optional<Skills> optSkill = this.skillsRepository.findById(id);


        if (optSkill.isEmpty()) {throw new ResourceNotFoundException("Skill","id",String.valueOf(id));}

        //Clear the relations with Projects before deleting the skill
        this.projectsRepository.deleteRelationsWithTechnologyId(id);

        this.skillsRepository.delete(optSkill.get());

        return optSkill.get();
    }

}
