package ar.com.matiasnetto.portfolio.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity @Table(name = "contact")
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String url;
    private String img;

    public Contact(String name, String url, String img) {
        this.name = name;
        this.url = url;
        this.img = img;
    }

}
