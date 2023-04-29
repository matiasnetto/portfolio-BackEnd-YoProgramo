package ar.com.matiasnetto.portfolio.mappers;

import ar.com.matiasnetto.portfolio.dto.EducationInDTO;
import ar.com.matiasnetto.portfolio.models.Education;
import org.springframework.stereotype.Component;

@Component
public class EducationInToEducation implements IMapper<EducationInDTO, Education>{
    @Override
    public Education map(EducationInDTO in) {
      Education myEducation = new Education();
        myEducation.setTitle(in.getTitle());
        myEducation.setInstitute(in.getInstitute());
        myEducation.setStarted_at(in.getStarted_at());
        myEducation.setEnd_at(in.getEnd_at());
        myEducation.setImage_url(in.getImage_url());
        myEducation.setOrd(in.getOrd());

        return myEducation;
    }
}
