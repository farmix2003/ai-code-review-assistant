package com.farrukh.aireview.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/**
 * Global exception handler for REST API endpoints.
 * Centralizes exception handling for the entire application using Spring's @RestControllerAdvice.
 * Provides custom response formatting for specific exception types.
 *
 * Currently handles:
 * - AuthException: Returns 401 UNAUTHORIZED status with error message
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles authentication exceptions thrown during user login/authorization operations.
     * Returns a 401 UNAUTHORIZED HTTP status with error details.
     *
     * @param e the AuthException containing the error message
     * @return ResponseEntity with UNAUTHORIZED status and error message in response body
     */
    @ExceptionHandler(AuthException.class)
    public ResponseEntity<String> handleAuthException(AuthException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", e.getMessage()).toString());
    }
}
