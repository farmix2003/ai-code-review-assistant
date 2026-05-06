package com.farrukh.aireview.service;

import com.farrukh.aireview.entity.User;
import com.farrukh.aireview.exception.AuthException;

/**
 * Service interface for managing user operations.
 * Defines the contract for user business logic including
 * user registration and email-based user lookup.
 *
 * Implementations of this interface handle the core business logic for
 * user registration, authentication, and profile management operations.
 */
public interface UserService {

    /**
     * Registers a new user in the system.
     * Persists the user entity to the database.
     *
     * @param user the user entity to register
     * @return the registered user with generated ID
     */
    User register(User user);

    User login(String email, String password) throws AuthException;

    /**
     * Finds a user by their email address.
     * Used for user authentication and lookup operations.
     *
     * @param email the email address to search for
     * @return the user with the specified email
     * @throws RuntimeException if no user is found with the given email
     */
    User findByEmail(String email);

}
