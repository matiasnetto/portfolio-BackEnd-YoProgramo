package ar.com.matiasnetto.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter @Setter
public class ExperienceInDTO {
    private String enterprise_name;
    private String job;
    private String description;
    private String image_url;
    private Date started_at;
    private Date end_at;
    private int ord;
}
