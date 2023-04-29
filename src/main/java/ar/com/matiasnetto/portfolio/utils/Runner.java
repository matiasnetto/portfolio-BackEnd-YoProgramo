package ar.com.matiasnetto.portfolio.utils;

import ar.com.matiasnetto.portfolio.models.*;
import ar.com.matiasnetto.portfolio.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Runner implements CommandLineRunner {
    private  final AuthorityRepository authorityRepository;
    private  final UserRepository userRepository;
    private final SkillsRepository skillsRepository;
    private final ContactsRepository contactsRepository;
    private final PersonRepository personRepository;
    private final EducationRepository educationRepository;

    public Runner(AuthorityRepository authorityRepository,
                  UserRepository userRepository,
                  SkillsRepository skillsRepository,
                  ContactsRepository contactsRepository,
                  PersonRepository personRepository,
                  EducationRepository educationRepository) {
        this.authorityRepository = authorityRepository;
        this.userRepository = userRepository;
        this.skillsRepository = skillsRepository;
        this.contactsRepository = contactsRepository;
        this.personRepository = personRepository;
        this.educationRepository = educationRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        if (this.authorityRepository.count() == 0) {
            this.authorityRepository.saveAll(List.of(
                    new Authority(AuthorityName.ADMIN),
                    new Authority(AuthorityName.USER)
            ));

        }

        if (this.userRepository.count() == 0) {
            this.userRepository.saveAll(List.of(
                    new User("admin@admin.com","admin","password",List.of(this.authorityRepository.findByName(AuthorityName.ADMIN).get())),
                    new User("user@user.com","user","password",List.of(this.authorityRepository.findByName(AuthorityName.USER).get())))
            );
        }

        if (this.skillsRepository.count() == 0) {
            this.skillsRepository.saveAll(List.of(
                    new Skills( "Javascript","https://javascribp.com/img.jpg",80,1),
                    new Skills( "Angular","https://angular.com/img.jpg",50,2),
                    new Skills( "Java","https://java.com/img.jpg",50,2)
            ));
        }


        if (this.personRepository.count() == 0) {
            Date myBirthday = new GregorianCalendar(2002, Calendar.NOVEMBER, 14).getTime();
            Person me = new Person(
                    "Matias Netto",
                    "Responsable, con capacidad de escucha, comprometido con lo que hago y abierto el trabajo en equipo.\n" +
                            "Me adapto a cualquier proyecto y reto que me propongan.",
                    "Argentina",
                    "matiasnetto03@gmail.com",
                    "Frontend Developer",
                    "",
                    "https://matiasnetto.com.ar/images/Me1.webp",
                    myBirthday,
                    List.of()
            );

            this.personRepository.save(me);

           List<Contact> myContacts = List.of(
                    new Contact("Linkedin", "https://www.linkedin.com/in/matiasnetto/","https://matiasnetto.com.ar/icons/linkedin-brands.svg",me),
                    new Contact("Github", "https://github.com/matiasnetto","https://matiasnetto.com.ar/icons/github-brands.svg", me)
            );

           this.contactsRepository.saveAll(myContacts);

           me.setSocial_media(myContacts);

           this.personRepository.save(me);

        }

        if (this.educationRepository.count() == 0) {

            this.educationRepository.saveAll(List.of(
                    new Education("Lic. Informatica", "UNQ","https://matiasnetto.com.ar/images/instituciones/unq.jpg",new GregorianCalendar(2021,Calendar.MARCH,1).getTime(),null,1),
                    new Education("SCRUM: Metodologias Agiles" ,"Fundacion Telefonica","https://matiasnetto.com.ar/images/instituciones/fundacion-telefonica.jpg",new GregorianCalendar(2022,Calendar.JUNE,1).getTime(),new GregorianCalendar(2022,Calendar.AUGUST,29).getTime(),2)
            ));
        }

//        if (this.personRepository.count() == 0) {
//            Date myBirthday = new GregorianCalendar(2002, Calendar.NOVEMBER, 14).getTime();
//            Person me = new Person(
//                    "Matias Netto",
//                    "Responsable, con capacidad de escucha, comprometido con lo que hago y abierto el trabajo en equipo.\n" +
//                            "Me adapto a cualquier proyecto y reto que me propongan.",
//                    "Argentina",
//                    "matiasnetto03@gmail.com",
//                    "Frontend Developer",
//                    "",
//                    "https://matiasnetto.com.ar/images/Me1.webp",
//                    myBirthday
//            );
//
//            List<Contact> myContacts = List.of(
//                    new Contact("Linkedin", "https://www.linkedin.com/in/matiasnetto/","https://matiasnetto.com.ar/icons/linkedin-brands.svg"),
//                    new Contact("Github", "https://github.com/matiasnetto","https://matiasnetto.com.ar/icons/github-brands.svg")
//            );
//
//            me.setSocial_media(myContacts);
//
//            this.personRepository.save(me);
//        }


//        if (this.contactsRepository.count() == 0) {
//            Person myPerson = this.personRepository.findById(1).get();
//            this.contactsRepository.saveAll((List.of(
//                    new Contact("Linkedin", "https://www.linkedin.com/in/matiasnetto/","https://matiasnetto.com.ar/icons/linkedin-brands.svg",myPerson),
//                    new Contact("Github", "https://github.com/matiasnetto","https://matiasnetto.com.ar/icons/github-brands.svg", myPerson)
//            )));
//        }
    }
}
