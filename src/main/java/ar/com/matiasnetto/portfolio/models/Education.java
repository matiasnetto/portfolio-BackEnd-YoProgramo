package ar.com.matiasnetto.portfolio.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor
@Entity @Table(name = "education")
public class Education {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String institute;
    private String image_url;
    private Date started_at;
    private Date end_at;
    private int ord;

    public Education(String title, String institute, String image_url, Date started_at, Date end_at, int ord) {
        this.title = title;
        this.institute = institute;
        this.image_url = image_url;
        this.started_at = started_at;
        this.end_at = end_at;
        this.ord = ord;
    }
}
