package ar.com.matiasnetto.portfolio.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
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
}
