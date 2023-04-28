package ar.com.matiasnetto.portfolio.controllers;

import ar.com.matiasnetto.portfolio.dto.ContactInDTO;
import ar.com.matiasnetto.portfolio.models.Contact;
import ar.com.matiasnetto.portfolio.services.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{id}")
    ResponseEntity<Contact> updateContact(@RequestBody ContactInDTO contactInDTO, @PathVariable int id) {
        Contact newContactData =  this.service.updateContact(contactInDTO, id);
        return new ResponseEntity<>(newContactData, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Contact> deleteContact(@PathVariable int id) {
        Contact contactDeleted = this.service.deleteContact(id);
        return new ResponseEntity<>(contactDeleted,HttpStatus.NO_CONTENT);
    }
}
