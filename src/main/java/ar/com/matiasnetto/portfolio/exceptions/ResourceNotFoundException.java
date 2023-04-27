package ar.com.matiasnetto.portfolio.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String element,String filed, String value) {
        super(String.format("%s not found with %s: %s",element,filed,value));
    }

}
