package ar.com.matiasnetto.portfolio.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "person_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Person person;

    public Contact(String name, String url, String img, Person person) {
        this.name = name;
        this.url = url;
        this.img = img;
        this.person = person;
    }

}
