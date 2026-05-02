package org.luis.proyecto.infrastructure.rest.controller;

import org.luis.proyecto.domain.exception.InvalidCredentialsException;
import org.luis.proyecto.domain.exception.ResourceNotFoundException;
import org.luis.proyecto.infrastructure.rest.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        ErrorResponse response = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                Instant.now()
        );
        return ResponseEntity
                .status(response.status())
                .body(response);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleInvalidCredentials(InvalidCredentialsException ex) {
        ErrorResponse response = new ErrorResponse(
                ex.getMessage(),
                HttpStatus.UNAUTHORIZED.value(),
                Instant.now()
        );
        return ResponseEntity
                .status(response.status())
                .body(response);
    }
}
