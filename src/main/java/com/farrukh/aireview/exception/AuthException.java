package com.farrukh.aireview.exception;

/**
 * Custom exception for authentication-related errors.
 * Extends RuntimeException to indicate authentication failures such as invalid credentials,
 * user not found, or unauthorized access attempts.
 *
 * This is an unchecked exception, allowing flexibility in error handling at the caller's discretion.
 */
public class AuthException extends RuntimeException {

    /**
     * Constructs an AuthException with a descriptive error message.
     *
     * @param message the detail message describing the authentication error
     */
    public AuthException(String message) {
        super(message);
    }
}