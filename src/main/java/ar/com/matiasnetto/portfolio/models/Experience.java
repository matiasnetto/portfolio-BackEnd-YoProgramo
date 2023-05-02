package ar.com.matiasnetto.portfolio.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter @NoArgsConstructor
@Entity @Table(name = "experience")
public class Experience {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String enterprise_name;
    private String job;
    private String description;
    private String image_url;
    private Date started_at;
    private Date end_at;
    private int ord;

    public Experience(String enterprise_name, String job, String description, String image_url, Date started_at, Date end_at, int ord) {
        this.enterprise_name = enterprise_name;
        this.job = job;
        this.description = description;
        this.image_url = image_url;
        this.started_at = started_at;
        this.end_at = end_at;
        this.ord = ord;
    }
}
