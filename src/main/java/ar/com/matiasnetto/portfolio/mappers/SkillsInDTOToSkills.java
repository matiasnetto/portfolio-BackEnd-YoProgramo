package ar.com.matiasnetto.portfolio.mappers;

import ar.com.matiasnetto.portfolio.dto.SkillsInDTO;
import ar.com.matiasnetto.portfolio.models.Skills;
import org.springframework.stereotype.Component;

@Component
public class SkillsInDTOToSkills implements  IMapper<SkillsInDTO, Skills>{
    @Override
    public Skills map(SkillsInDTO in) {
        Skills mySkill = new Skills();
        mySkill.setTechnology(in.getTechnology());
        mySkill.setImage_url(in.getImage_url());
        mySkill.setPercent(in.getPercent());
        mySkill.setOrd(in.getOrd());

        return mySkill;
    }
}
