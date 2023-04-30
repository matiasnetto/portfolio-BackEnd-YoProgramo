package ar.com.matiasnetto.portfolio.controllers;

import ar.com.matiasnetto.portfolio.dto.EducationInDTO;
import ar.com.matiasnetto.portfolio.models.Education;
import ar.com.matiasnetto.portfolio.services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    @Autowired
    EducationService service;

    @GetMapping
    public List<Education> getAllEducation() {
        return this.service.getAllEducation();
    }

    @PostMapping
    public ResponseEntity<Education> createNewEducation(@RequestBody EducationInDTO educationDTO) {
        Education myEducation = this.service.createNewEducation(educationDTO);

        return new ResponseEntity<>(myEducation, HttpStatus.CREATED);
    }
    
   @PutMapping("/{id}")
    public ResponseEntity<Education> updateEducation(@RequestBody EducationInDTO educationInDTO,@PathVariable int id) {
        Education myEducation = this.service.updateEducation(educationInDTO,id);
        return new ResponseEntity<>(myEducation, HttpStatus.OK);
    }

   @DeleteMapping("/{id}")
    public ResponseEntity<Education> deleteEducation(@PathVariable int id) {
        Education myEducation = this.service.deleteEducation(id);
        return new ResponseEntity<>(myEducation,HttpStatus.NO_CONTENT);
    }
}
