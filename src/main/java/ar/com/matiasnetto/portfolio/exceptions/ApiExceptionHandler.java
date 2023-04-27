package ar.com.matiasnetto.portfolio.exceptions;

import ar.com.matiasnetto.portfolio.dto.ApiExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ApiExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        HttpStatus currentStatus = HttpStatus.NOT_FOUND;
        ApiExceptionResponse res = new ApiExceptionResponse(
                e.getMessage(),
                currentStatus
        );

        return new ResponseEntity<>(res, currentStatus);

    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ApiExceptionResponse> handleGlobalExceptions(Exception e) {
        HttpStatus currentStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiExceptionResponse res = new ApiExceptionResponse(
                e.getMessage(),
                currentStatus
        );

        return new ResponseEntity<>(res, currentStatus);
    }

}
