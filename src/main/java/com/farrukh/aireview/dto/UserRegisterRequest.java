package com.farrukh.aireview.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for user registration requests.
 * Encapsulates user details required to create a new user account.
 * Validates email format and ensures both email and password meet requirements.
 *
 * Fields:
 * - email: User's email address (required, must be valid email format, not empty)
 * - password: User's password (required, not blank, not empty)
 */
@Getter
@Setter
public class UserRegisterRequest {

    // User's email address with multiple validations (email format, not blank, not empty)
    @Email
    @NotBlank
    @NotEmpty
    private String email;

    // User's password with validations (not blank, not empty)
    @NotBlank
    @NotEmpty
    private String password;

}
