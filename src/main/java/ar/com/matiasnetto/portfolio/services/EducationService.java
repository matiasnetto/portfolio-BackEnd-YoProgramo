package ar.com.matiasnetto.portfolio.services;

import ar.com.matiasnetto.portfolio.dto.EducationInDTO;
import ar.com.matiasnetto.portfolio.exceptions.ResourceNotFoundException;
import ar.com.matiasnetto.portfolio.mappers.EducationInToEducation;
import ar.com.matiasnetto.portfolio.models.Education;
import ar.com.matiasnetto.portfolio.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService {

    @Autowired
    EducationRepository repository;
    @Autowired
    EducationInToEducation mapper;

    public List<Education> getAllEducation() {
        return this.repository.findAll();
    }

    public Education createNewEducation(EducationInDTO educationDTO) {
        return this.repository.save(this.mapper.map(educationDTO));
    }

    public Education updateEducation(EducationInDTO educationInDTO, int id) {
        Optional<Education> optEducation = this.repository.findById(id);

        if (optEducation.isEmpty()) {throw new ResourceNotFoundException("Education", "id", String.valueOf(id));}

        Education myNewEducationData = this.mapper.map(educationInDTO);
        myNewEducationData.setId(optEducation.get().getId());

        return this.repository.save(myNewEducationData);
    }

    public Education deleteEducation(int id) {
        Optional<Education> optEducation = this.repository.findById(id);

        if (optEducation.isEmpty()) {throw new ResourceNotFoundException("Education", "id", String.valueOf(id));}

        this.repository.deleteById(id);
        return optEducation.get();
    }

}
