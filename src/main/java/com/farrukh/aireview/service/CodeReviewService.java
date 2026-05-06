package com.farrukh.aireview.service;

import com.farrukh.aireview.entity.CodeReview;
import com.farrukh.aireview.entity.User;

import java.util.List;

/**
 * Service interface for managing code review operations.
 * Defines the contract for code review business logic including
 * saving new reviews and retrieving reviews for specific users.
 *
 * Implementations of this interface handle the core business logic for
 * code review submission, storage, and retrieval operations.
 */
public interface CodeReviewService {

    /**
     * Saves a new code review submission.
     * Persists the code review entity to the database.
     *
     * @param codeReview the code review entity to save
     * @return the saved code review with generated ID
     */
    CodeReview save(CodeReview codeReview);

    /**
     * Retrieves all code reviews submitted by a specific user.
     *
     * @param user the user whose code reviews to retrieve
     * @return a list of code reviews belonging to the specified user
     */
    List<CodeReview> getUserReview(User user);

}
