package ar.com.matiasnetto.portfolio.services;

import ar.com.matiasnetto.portfolio.dto.ContactInDTO;
import ar.com.matiasnetto.portfolio.mappers.ContactInDTOToContact;
import ar.com.matiasnetto.portfolio.models.Contact;
import ar.com.matiasnetto.portfolio.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsService {
    @Autowired
    ContactsRepository repository;
    @Autowired
    ContactInDTOToContact mapper;

    public List<Contact> findAllContacts() {
        return this.repository.findAll();
    }

    public Contact createNewContact(ContactInDTO contactDTO) {
        return this.repository.save(this.mapper.map(contactDTO));
    }


}
