package ar.com.matiasnetto.portfolio.mappers;

import ar.com.matiasnetto.portfolio.dto.ContactInDTO;
import ar.com.matiasnetto.portfolio.models.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactInDTOToContact implements IMapper<ContactInDTO, Contact>{
    @Override
    public Contact map(ContactInDTO in) {
        Contact myContact = new Contact();

        myContact.setName(in.getName());
        myContact.setUrl(in.getUrl());
        myContact.setImg(in.getImg());

        return myContact;
    }
}
