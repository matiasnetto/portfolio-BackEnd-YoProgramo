package ar.com.matiasnetto.portfolio.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
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

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "person")
    private List<Contact> social_media;
}
