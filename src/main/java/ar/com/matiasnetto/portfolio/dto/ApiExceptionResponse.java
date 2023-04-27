package ar.com.matiasnetto.portfolio.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Getter
public class ApiExceptionResponse {
    private final String message;
    private final String statusCode;
    private final ZonedDateTime timestamp;

    public ApiExceptionResponse(String message, HttpStatus httpStatus) {
        this.message = message;
        this.statusCode = httpStatus.toString();
        this. timestamp = ZonedDateTime.now();
    }
}
