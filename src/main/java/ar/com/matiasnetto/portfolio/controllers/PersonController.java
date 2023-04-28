package ar.com.matiasnetto.portfolio.controllers;

import ar.com.matiasnetto.portfolio.models.Person;
import ar.com.matiasnetto.portfolio.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/{id}")
    public Person getPersonInformation(@PathVariable int id) {
      return this.personService.getPersonById(id);
    }
}
