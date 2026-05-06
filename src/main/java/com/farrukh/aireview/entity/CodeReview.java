package com.farrukh.aireview.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entity representing a code review submission.
 * This entity stores code snippets submitted by users for AI-powered review,
 * along with the AI-generated response and metadata about when the review was created.
 * -----
 * Features:
 * - Stores source code in a CLOB (Character Large Object) column for large code snippets
 * - Maintains relationship with User entity (many-to-one)
 * - Auto-generates timestamp on record creation
 * - Uses Lombok annotations for boilerplate reduction
 */
@Entity
@Table(name = "code_reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CodeReview extends  BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Programming language of the submitted code
    @Column(nullable = false)
    private String language;

    // The actual source code submitted for review
    @Lob
    @Column(nullable = false)
    private String sourceCode;

    // The AI-generated review response
    @Lob
    private String aiResponse;

    // Reference to the user who submitted the code review
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

}