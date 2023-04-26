package ar.com.matiasnetto.portfolio.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity @Table(name = "skills",uniqueConstraints = {@UniqueConstraint(columnNames = {"technology"})} )
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String technology;
    private String image_url;
    private int percent;
    private int ord;
}
