package ar.com.matiasnetto.portfolio.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity @Table(name = "about_me")
public class AboutMe {
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

    //ONE TO MANY contact
    private Integer[] social_media;
}
