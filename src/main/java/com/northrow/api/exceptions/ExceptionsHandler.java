package com.northrow.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * The type ExceptionsHandler.
 */
@ControllerAdvice
public class ExceptionsHandler {

    /**
     * Handle exception response entity.
     *
     * @param e the exception
     * @return the custom exception as a response entity
     */
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleException(ResourceNotFoundException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        NotFoundErrorMessage error = new NotFoundErrorMessage(LocalDateTime.now() ,e.getMessage(), status);

        return new ResponseEntity<>(error, status);
    }
}
