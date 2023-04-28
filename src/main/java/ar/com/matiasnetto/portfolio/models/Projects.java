package ar.com.matiasnetto.portfolio.models;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Set;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "technology_in_project",
            joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id", referencedColumnName = "id"))
    private Set<Skills> technologies;
}
