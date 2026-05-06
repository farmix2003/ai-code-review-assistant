package com.farrukh.aireview.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * Base entity class providing common auditing fields for all entities.
 * This class is designed to be extended by other entity classes to automatically
 * inherit timestamp tracking functionality for creation and modification dates.
 *
 * Features:
 * - Automatic timestamp population using Spring Data JPA auditing
 * - Immutable createdAt field (set once on creation)
 * - Automatically updated updatedAt field on entity modifications
 * - Uses @MappedSuperclass to allow inheritance without creating a separate table
 *
 * To use this base entity, other entity classes should extend BaseEntity:
 * <pre>
 * {@code
 * @Entity
 * public class MyEntity extends BaseEntity {
 *     // entity-specific fields
 * }
 * }
 * </pre>
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    /**
     * Timestamp when the entity was first created.
     * This field is automatically populated by Spring Data JPA auditing
     * and cannot be updated after initial creation.
     */
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * Timestamp when the entity was last modified.
     * This field is automatically updated by Spring Data JPA auditing
     * whenever the entity is saved or updated.
     */
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
