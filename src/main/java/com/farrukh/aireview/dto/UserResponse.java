package com.farrukh.aireview.dto;

import com.farrukh.aireview.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) for user responses.
 * Encapsulates user information returned to the client after successful authentication or registration.
 * Uses Builder pattern for flexible object construction.
 *
 * Fields:
 * - id: Unique identifier of the user (optional, may be null in some responses)
 * - email: User's email address
 * - role: User's assigned role (USER or ADMIN)
 */
@Getter
@Setter
@Builder
public class UserResponse {

    // User's unique identifier
    private Long id;

    // User's email address
    private String email;

    // User's role (USER or ADMIN)
    private Role role;

}
