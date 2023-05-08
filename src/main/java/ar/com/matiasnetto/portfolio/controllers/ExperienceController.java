package ar.com.matiasnetto.portfolio.controllers;

import ar.com.matiasnetto.portfolio.dto.ExperienceInDTO;
import ar.com.matiasnetto.portfolio.models.Experience;
import ar.com.matiasnetto.portfolio.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {
   @Autowired
   ExperienceService service;

   @CrossOrigin
   @GetMapping
   public List<Experience> getAllExperience() {
      return this.service.getAllExperience();
   }

   @PostMapping
   public Experience createNewExperience(@RequestBody ExperienceInDTO experienceInDTO) {
      return this.service.createNewExperience(experienceInDTO);
   }

   @PutMapping("/{id}")
   public Experience updateExperience(@RequestBody ExperienceInDTO experienceInDTO, @PathVariable int id) {
      return this.service.updateExperience(experienceInDTO, id);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Experience> deleteExperience(@PathVariable int id) {
      Experience myExperience = this.service.deleteExperience(id);
      return new ResponseEntity<Experience>(myExperience, HttpStatus.NO_CONTENT);
   }
}
