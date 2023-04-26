package ar.com.matiasnetto.portfolio.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity @Table(name = "education")
public class Education {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String image_url;
    private Date started_at;
    private Date end_at;
    private int ord;
}
