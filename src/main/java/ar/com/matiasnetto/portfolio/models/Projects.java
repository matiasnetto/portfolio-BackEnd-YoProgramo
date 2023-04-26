package ar.com.matiasnetto.portfolio.models;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity @Table(name = "projects")
public class Projects {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String image_url;
    private Date end_at;
    private String description;
    private String project_url;
    private String github_url;
    private int ord;
}
