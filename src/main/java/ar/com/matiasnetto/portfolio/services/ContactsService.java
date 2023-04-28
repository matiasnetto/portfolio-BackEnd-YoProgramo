package ar.com.matiasnetto.portfolio.services;

import ar.com.matiasnetto.portfolio.dto.ContactInDTO;
import ar.com.matiasnetto.portfolio.exceptions.ResourceNotFoundException;
import ar.com.matiasnetto.portfolio.mappers.ContactInDTOToContact;
import ar.com.matiasnetto.portfolio.models.Contact;
import ar.com.matiasnetto.portfolio.models.Person;
import ar.com.matiasnetto.portfolio.repository.ContactsRepository;
import ar.com.matiasnetto.portfolio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactsService {
    @Autowired
    ContactsRepository contactsRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    ContactInDTOToContact mapper;

    public List<Contact> findAllContacts() {
        return this.contactsRepository.findAll();
    }

    public Contact createNewContact(ContactInDTO contactDTO) {
        Optional<Person> optPerson = this.personRepository.findById(contactDTO.getPerson_id());

        if (optPerson.isEmpty()) {throw new ResourceNotFoundException("Person", "id", String.valueOf(contactDTO.getPerson_id()));}
        Contact newContact = this.mapper.map(contactDTO);

        //Set person
        newContact.setPerson(optPerson.get());

        return this.contactsRepository.save(newContact);
    }

    public Contact updateContact(ContactInDTO contactDTO, int id) throws ResourceNotFoundException{
        Optional<Contact>  optContact = this.contactsRepository.findById(id);
        //Evaluate if contact exists
        if (optContact.isEmpty()) {throw  new ResourceNotFoundException("Contact", "id", String.valueOf(id));}

        Contact newContactData = this.mapper.map(contactDTO);
        newContactData.setId(optContact.get().getId());
        newContactData.setPerson(optContact.get().getPerson());

        return this.contactsRepository.save(newContactData);
    }

    public Contact deleteContact(int id) throws ResourceNotFoundException {
       Optional<Contact> optContact = this.contactsRepository.findById(id);

       if (optContact.isEmpty()) {throw  new ResourceNotFoundException("Contact", "id", String.valueOf(id));}

       this.contactsRepository.deleteById(id);

       return optContact.get();
    }


}
