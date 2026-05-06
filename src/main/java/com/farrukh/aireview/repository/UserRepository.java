package com.farrukh.aireview.repository;

import com.farrukh.aireview.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing User entities.
 * Provides data access methods for user management operations including
 * CRUD operations inherited from JpaRepository and custom query methods
 * for finding users by email and checking email existence.
 *
 * This repository handles user authentication, registration, and profile management
 * within the AI Code Review Assistant system.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds a user by their email address.
     * Used primarily for authentication and user lookup operations.
     *
     * @param email the email address to search for
     * @return an Optional containing the user if found, or empty if not found
     */
    Optional<User> findByEmail(String email);

    /**
     * Checks if a user exists with the given email address.
     * Useful for validation during user registration to prevent duplicate emails.
     *
     * @param email the email address to check for existence
     * @return true if a user with the email exists, false otherwise
     */
    boolean existsByEmail(String email);

}
