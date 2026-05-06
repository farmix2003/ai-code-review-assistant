package com.farrukh.aireview.controller;

import com.farrukh.aireview.dto.LoginRequest;
import com.farrukh.aireview.dto.UserResponse;
import com.farrukh.aireview.entity.Role;
import com.farrukh.aireview.entity.User;
import com.farrukh.aireview.exception.AuthException;
import com.farrukh.aireview.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing user authentication operations.
 * Handles user registration and login requests, providing endpoints for these operations.
 * All endpoints use HTTP POST mapping and return user information in response.
 *
 * Base URL: /api/users
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    // User service dependency for business logic
    private final UserService userService;

    /**
     * Endpoint for user registration.
     * Accepts a new user with email and password, assigns USER role, and saves to database.
     *
     * @param user the user registration details (email and password required)
     * @return ResponseEntity containing user email and assigned role
     */
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody User user) {

        user.setRole(Role.USER);

        User newUser = userService.register(user);

       UserResponse response = UserResponse.builder()
              .email(user.getEmail())
              .role(newUser.getRole())
              .build();

        return ResponseEntity.ok(response);
    }

    /**
     * Endpoint for user login.
     * Authenticates user based on email and password credentials.
     *
     * @param request login credentials (email and password)
     * @return ResponseEntity containing authenticated user details (id, email, and role)
     * @throws AuthException if email or password is invalid
     */
    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@Valid @RequestBody LoginRequest request) throws AuthException {

        User user = userService.login(request.getEmail(), request.getPassword());

        UserResponse response = UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
        return ResponseEntity.ok(response);
}

}
