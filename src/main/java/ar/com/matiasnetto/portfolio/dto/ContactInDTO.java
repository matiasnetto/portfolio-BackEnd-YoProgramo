package ar.com.matiasnetto.portfolio.dto;

import lombok.Getter;

@Getter
public class ContactInDTO {
    private String name;
    private String url;
    private String img;

    public ContactInDTO(String name, String url, String img) {
        this.name = name;
        this.url = url;
        this.img = img;
    }
}
