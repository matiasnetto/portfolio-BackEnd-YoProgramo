package ar.com.matiasnetto.portfolio.controllers;

import ar.com.matiasnetto.portfolio.models.Contact;
import ar.com.matiasnetto.portfolio.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController @RequestMapping("/api/contact")
public class ContactsController {

    @Autowired
    ContactsRepository repository;

    @GetMapping
    List<Contact> getAllContacts() {
       return this.repository.findAll();
    }
}
