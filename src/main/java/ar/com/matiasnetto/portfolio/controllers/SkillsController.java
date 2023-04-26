package ar.com.matiasnetto.portfolio.controllers;


import ar.com.matiasnetto.portfolio.dto.SkillsInDTO;
import ar.com.matiasnetto.portfolio.models.Skills;
import ar.com.matiasnetto.portfolio.repository.SkillsRepository;
import ar.com.matiasnetto.portfolio.services.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/skills")
public class SkillsController {

    @Autowired
    SkillsService service;

    @GetMapping
    List<Skills> getSkills() {
        List<Skills> mySkills = this.service.getAllSkills();
        System.out.println("WOrking: " + mySkills);
        return mySkills;
    }
//
//    @PostMapping
//    String test() {
//       return  "ANashex" ;
//    }

    @PostMapping
    Skills createNewSkill(@RequestBody SkillsInDTO newSkillDTO) {
        System.out.println(newSkillDTO);
        return this.service.createNewSkill(newSkillDTO);

    }
}
