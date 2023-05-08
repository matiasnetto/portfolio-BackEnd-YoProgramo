package ar.com.matiasnetto.portfolio.controllers;

import ar.com.matiasnetto.portfolio.dto.PersonInDTO;
import ar.com.matiasnetto.portfolio.models.Person;
import ar.com.matiasnetto.portfolio.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

  @Autowired
  PersonService personService;

  @CrossOrigin
  @GetMapping("/{id}")
  public Person getPersonInformation(@PathVariable int id) {
    return this.personService.getPersonById(id);
  }

  @PutMapping("/{id}")
  public Person updatePersonInformation(@RequestBody PersonInDTO personDTO, @PathVariable int id) {
    return this.personService.updatePerson(personDTO, id);
  }
}
