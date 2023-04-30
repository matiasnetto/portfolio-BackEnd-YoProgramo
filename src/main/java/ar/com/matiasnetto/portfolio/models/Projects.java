package ar.com.matiasnetto.portfolio.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data @NoArgsConstructor
@Entity @Table(name = "projects",uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
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

    public Projects(String title, String image_url, Date end_at, String description, String project_url, String github_url, int ord, Set<Skills> technologies) {
        this.title = title;
        this.image_url = image_url;
        this.end_at = end_at;
        this.description = description;
        this.project_url = project_url;
        this.github_url = github_url;
        this.ord = ord;
        this.technologies = technologies;
    }
}
