package ar.com.matiasnetto.portfolio.mappers;

import ar.com.matiasnetto.portfolio.dto.ExperienceInDTO;
import ar.com.matiasnetto.portfolio.models.Experience;
import org.springframework.stereotype.Component;

@Component
public class ExperienceInDTOToExperience implements IMapper<ExperienceInDTO, Experience>{
    @Override
    public Experience map(ExperienceInDTO in) {
        Experience myExperience = new Experience();

        myExperience.setEnterprise_name(in.getEnterprise_name());
        myExperience.setJob(in.getJob());
        myExperience.setDescription(in.getDescription());
        myExperience.setImage_url(in.getImage_url());
        myExperience.setStarted_at(in.getStarted_at());
        myExperience.setEnd_at(in.getEnd_at());
        myExperience.setOrd(in.getOrd());

        return myExperience;
    }
}
