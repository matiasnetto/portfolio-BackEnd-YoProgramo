package ar.com.matiasnetto.portfolio.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity @Table(name = "skills",uniqueConstraints = {@UniqueConstraint(columnNames = {"technology"})} )
public class Skills {

    public Skills(String technology, String image_url, int percent, int ord) {
        this.technology = technology;
        this.image_url = image_url;
        this.percent = percent;
        this.ord = ord;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String technology;
    private String image_url;
    private int percent;
    private int ord;
}
