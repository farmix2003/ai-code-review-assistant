package com.farrukh.aireview.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for user login requests.
 * Encapsulates user credentials required for authentication.
 * Validates email format and ensures both email and password are provided.
 *
 * Fields:
 * - email: User's email address (required, must be valid email format)
 * - password: User's password (required, non-blank)
 */
@Getter
@Setter
public class LoginRequest {

    // User's email address with validation
    @Email
    @NotBlank
    private String email;

    // User's password credential
    @NotBlank
    private String password;

}
