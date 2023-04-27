package ar.com.matiasnetto.portfolio.controllers;

import ar.com.matiasnetto.portfolio.dto.ContactInDTO;
import ar.com.matiasnetto.portfolio.models.Contact;
import ar.com.matiasnetto.portfolio.repository.ContactsRepository;
import ar.com.matiasnetto.portfolio.services.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/api/contacts")
public class ContactsController {

    @Autowired
    ContactsService service;

    @GetMapping
    List<Contact> getAllContacts() {
       return this.service.findAllContacts();
    }

    @PostMapping
    Contact createNewContact(@RequestBody ContactInDTO contactInDTO) {
       return this.service.createNewContact(contactInDTO) ;
    }
}
