package ar.com.matiasnetto.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PersonInDTO {
    private String name;
    private String description;
    private String nationality;
    private String mail;
    private String occupation;
    private String background_img_header_url;
    private String profile_img_url;
    private Date date_of_birth;

}
