package ar.com.matiasnetto.portfolio.dto;

import lombok.Data;

@Data
public class SkillsInDTO {
    private String technology;
    private String image_url;
    private int percent;
    private int ord;
}
