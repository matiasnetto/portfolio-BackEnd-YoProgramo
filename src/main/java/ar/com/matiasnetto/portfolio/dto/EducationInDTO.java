package ar.com.matiasnetto.portfolio.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter @Setter
public class EducationInDTO {
    private String title;
    private String institute;
    private String image_url;
    private Date started_at;
    private Date end_at;
    private int ord;
}
