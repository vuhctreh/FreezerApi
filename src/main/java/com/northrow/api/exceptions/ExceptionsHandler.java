package com.northrow.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleException(ResourceNotFoundException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ErrorMessage error = new ErrorMessage(LocalDateTime.now() ,e.getMessage(), status);

        return new ResponseEntity<Object>(error, status);
    }
}
