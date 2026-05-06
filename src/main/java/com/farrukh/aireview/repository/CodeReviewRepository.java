package com.farrukh.aireview.repository;

import com.farrukh.aireview.entity.CodeReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing CodeReview entities.
 * Provides data access methods for code review operations including
 * CRUD operations inherited from JpaRepository and custom query methods
 * for finding code reviews by user or programming language.
 *
 * This repository handles persistence and retrieval of code review submissions
 * submitted by users for AI-powered analysis.
 */
@Repository
public interface CodeReviewRepository  extends JpaRepository<CodeReview, Long> {

    /**
     * Finds all code reviews submitted by a specific user.
     *
     * @param userId the ID of the user whose code reviews to retrieve
     * @return a list of code reviews belonging to the specified user
     */
    List<CodeReview> findByUserId(Long userId);

    /**
     * Finds all code reviews written in a specific programming language.
     *
     * @param language the programming language to filter by (e.g., "java", "python")
     * @return a list of code reviews for the specified programming language
     */
    List<CodeReview> findByLanguage(String language);

}
