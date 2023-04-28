package ar.com.matiasnetto.portfolio.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data @NoArgsConstructor
@Entity @Table(name = "persons")
public class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String nationality;
    private String mail;
    private String occupation;
    private String background_img_header_url;
    private String profile_img_url;
    private Date date_of_birth;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = Contact.class, orphanRemoval = true)
    private List<Contact> social_media;

    public Person(
            String name,
            String description,
            String nationality,
            String mail,
            String occupation,
            String background_img_header_url,
            String profile_img_url,
            Date date_of_birth,
            List<Contact> social_media) {
        this.name = name;
        this.description = description;
        this.nationality = nationality;
        this.mail = mail;
        this.occupation = occupation;
        this.background_img_header_url = background_img_header_url;
        this.profile_img_url = profile_img_url;
        this.date_of_birth = date_of_birth;
        this.social_media = social_media;
    }

    public Person(
            String name,
            String description,
            String nationality,
            String mail,
            String occupation,
            String background_img_header_url,
            String profile_img_url,
            Date date_of_birth
            ) {
        this.name = name;
        this.description = description;
        this.nationality = nationality;
        this.mail = mail;
        this.occupation = occupation;
        this.background_img_header_url = background_img_header_url;
        this.profile_img_url = profile_img_url;
        this.date_of_birth = date_of_birth;
    }
}
