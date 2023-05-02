package ar.com.matiasnetto.portfolio.services;

import ar.com.matiasnetto.portfolio.dto.ExperienceInDTO;
import ar.com.matiasnetto.portfolio.exceptions.ResourceNotFoundException;
import ar.com.matiasnetto.portfolio.mappers.ExperienceInDTOToExperience;
import ar.com.matiasnetto.portfolio.models.Experience;
import ar.com.matiasnetto.portfolio.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {

    @Autowired
    ExperienceRepository repository;
    @Autowired
    ExperienceInDTOToExperience mapper;

    public List<Experience> getAllExperience() {
        return  this.repository.findAll();
    }

    public Experience createNewExperience(ExperienceInDTO experienceInDTO) {
        Experience myExperience = this.mapper.map(experienceInDTO);
        return this.repository.save(myExperience);
    }

    public Experience updateExperience(ExperienceInDTO experienceInDTO, int id) {
        Optional<Experience> myExperience = this.repository.findById(id);

        if (myExperience.isEmpty()) {throw new ResourceNotFoundException("Experience", "id", String.valueOf(id));}

        Experience newData = this.mapper.map(experienceInDTO);
        newData.setId(myExperience.get().getId());


        return this.repository.save(newData);
    }

    public Experience deleteExperience(int id) {
        Optional<Experience> myExperience = this.repository.findById(id);

        if (myExperience.isEmpty()) {throw new ResourceNotFoundException("Experience", "id", String.valueOf(id));}

        this.repository.deleteById(id);
        return myExperience.get();
    }
}
