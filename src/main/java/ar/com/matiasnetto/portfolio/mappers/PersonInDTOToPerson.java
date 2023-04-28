package ar.com.matiasnetto.portfolio.mappers;

import ar.com.matiasnetto.portfolio.dto.PersonInDTO;
import ar.com.matiasnetto.portfolio.models.Person;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class PersonInDTOToPerson implements IMapper<PersonInDTO, Person>{
    @Override
    public Person map(PersonInDTO in) {
        Person myPerson = new Person();

        myPerson.setName(in.getName());
        myPerson.setDescription(in.getDescription());
        myPerson.setNationality(in.getNationality());
        myPerson.setMail(in.getMail());
        myPerson.setOccupation(in.getOccupation());
        myPerson.setBackground_img_header_url(in.getBackground_img_header_url());
        myPerson.setProfile_img_url(in.getProfile_img_url());
        myPerson.setDate_of_birth(in.getDate_of_birth());
        myPerson.setSocial_media(List.of());


        return myPerson;
    }
}
