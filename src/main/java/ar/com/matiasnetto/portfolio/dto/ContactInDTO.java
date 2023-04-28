package ar.com.matiasnetto.portfolio.dto;

import lombok.Getter;

@Getter
public class ContactInDTO {
    private final String name;
    private final String url;
    private final String img;
    private final int person_id;

    public ContactInDTO(String name, String url, String img, int person_id) {
        this.name = name;
        this.url = url;
        this.img = img;
        this.person_id = person_id;
    }
}
