package ar.com.matiasnetto.portfolio.services;

import ar.com.matiasnetto.portfolio.exceptions.ResourceNotFoundException;
import ar.com.matiasnetto.portfolio.models.Person;
import ar.com.matiasnetto.portfolio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository repository;

    public Person getPersonById(int id) throws ResourceNotFoundException{
        Optional<Person> optPerson = this.repository.findById(id);

        if (optPerson.isEmpty()) {throw new ResourceNotFoundException("Person","id",String.valueOf(id));}

        return optPerson.get();
    }
}
