package ar.com.matiasnetto.portfolio.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity @Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String url;
    private String img;
}
