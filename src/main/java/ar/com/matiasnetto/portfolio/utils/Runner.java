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
    private final ProjectsRepository projectsRepository;
    private final ExperienceRepository experienceRepository;

    public Runner(AuthorityRepository authorityRepository,
                  UserRepository userRepository,
                  SkillsRepository skillsRepository,
                  ContactsRepository contactsRepository,
                  PersonRepository personRepository,
                  EducationRepository educationRepository,
                  ProjectsRepository projectsRepository,
                  ExperienceRepository experienceRepository) {
        this.authorityRepository = authorityRepository;
        this.userRepository = userRepository;
        this.skillsRepository = skillsRepository;
        this.contactsRepository = contactsRepository;
        this.personRepository = personRepository;
        this.educationRepository = educationRepository;
        this.projectsRepository = projectsRepository;
        this.experienceRepository = experienceRepository;

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
                    new Skills( "React","https://react.com/img.jpg",90,2),
                    new Skills( "Angular","https://angular.com/img.jpg",50,3),
                    new Skills( "Java","https://java.com/img.jpg",50,4)
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

        if (this.projectsRepository.count() == 0) {
            Skills js = this.skillsRepository.findById(1).get();
            Skills react = this.skillsRepository.findById(2).get();
            Skills angular = this.skillsRepository.findById(3).get();
            Skills java = this.skillsRepository.findById(4).get();

            Set<Skills> mySet1 = new HashSet<Skills>();
            Set<Skills> mySet2 = new HashSet<Skills>();
            mySet1.add(js);
            mySet1.add(react);
            mySet2.add(js);
            mySet2.add(angular);
            mySet2.add(java);
            this.projectsRepository.saveAll(List.of(
                    new Projects(
                            "Urban Cothes",
                            "https://matiasnetto.com.ar/_next/image?url=%2Fimages%2Fprojects%2FUrbanClothes%2Furban-clothes-img-1.jpg&w=1920&q=75",
                            new GregorianCalendar(2022,Calendar.JUNE,1).getTime(),
                            "E-Commerce",
                            "https://catalogue-with-cart.web.app/",
                            "https://github.com/matiasnetto/urban-clothes-commerce",
                            1,
                            mySet1
                    ),
                    new Projects(
                            "Portfolio YoProgramo",
                            "https://Yoprogramo.com.ar",
                            new GregorianCalendar(2023,Calendar.MARCH,1).getTime(),
                            "Portfolio",
                            null,
                            "https://github.com/matiasnetto/yoprogramoportfolio",
                            2,
                            mySet2
                    )
            ));
        }

        if (this.experienceRepository.count() == 0) {
            Date myDate = new GregorianCalendar(2022,Calendar.MARCH,12).getTime();
            this.experienceRepository.saveAll(List.of(
                    new Experience(
                            "Empresa1",
                            "Junior Frontend Developer",
                            "Some quick example text to build on the card title and make up the bulk of the card's content. ",
                            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.shareicon.net%2Fdata%2F2016%2F07%2F10%2F119930_google_512x512.png&f=1&nofb=1&ipt=51cb0b840d5df7d05ee3b31b3a3a629ef5293e90a7c4e2bd753eda624a9167be&ipo=images",
                            myDate,
                            null,
                            1),
                    new Experience(
                            "Empresa2",
                            "Junior Frontend Developer",
                            "Some quick example text to build on the card title and make up the bulk of the card's content. ",
                            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.shareicon.net%2Fdata%2F2016%2F07%2F10%2F119930_google_512x512.png&f=1&nofb=1&ipt=51cb0b840d5df7d05ee3b31b3a3a629ef5293e90a7c4e2bd753eda624a9167be&ipo=images",
                            myDate,
                            null,
                            2),
                    new Experience(
                            "Empresa3",
                            "Junior Frontend Developer Anashex",
                            "Some quick example text to build on the card title and make up the bulk of the card's content. ",
                            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fwww.shareicon.net%2Fdata%2F2016%2F07%2F10%2F119930_google_512x512.png&f=1&nofb=1&ipt=51cb0b840d5df7d05ee3b31b3a3a629ef5293e90a7c4e2bd753eda624a9167be&ipo=images",
                            myDate,
                            null,
                            1)

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
