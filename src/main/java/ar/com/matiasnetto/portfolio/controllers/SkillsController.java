package ar.com.matiasnetto.portfolio.controllers;

import ar.com.matiasnetto.portfolio.dto.SkillsInDTO;
import ar.com.matiasnetto.portfolio.models.Skills;
import ar.com.matiasnetto.portfolio.services.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/skills")
public class SkillsController {

    @Autowired
    SkillsService service;

    @GetMapping
    ResponseEntity<List<Skills>> getSkills() {
        List<Skills> mySkills = this.service.getAllSkills();
        return new ResponseEntity<>(mySkills, HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Skills> createNewSkill(@RequestBody SkillsInDTO newSkillDTO) {
        Skills newSkill = this.service.createNewSkill(newSkillDTO);
        return new ResponseEntity<>(newSkill, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Skills> updateSkill(@RequestBody SkillsInDTO newData, @PathVariable int id) {
        Skills updatedSkill = this.service.updateSkill(newData, id);
        return new ResponseEntity<>(updatedSkill,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Skills> deleteSkill(@PathVariable int id) {
        Skills mySkill = this.service.deleteSkill(id);
        return new ResponseEntity<>(mySkill, HttpStatus.NO_CONTENT);
    }
}
