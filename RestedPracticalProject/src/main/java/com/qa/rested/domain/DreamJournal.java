package com.qa.rested.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "journal")
public final class DreamJournal {

    @Id
    @Column(name = "id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "sleep_rating", length = 2, nullable = false)
    private Integer sleepRating;

    @Column(name = "description", length = 500, nullable = true)
    private String description;

    public DreamJournal(
            final UUID id,
            final Integer sleepRating,           
            final String description
    ) {
        this.id = Optional.ofNullable(id).orElse(UUID.randomUUID());
        this.sleepRating = sleepRating; 
        this.description = description;
    }

    public DreamJournal() {
    }


    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }


    public Integer getSleepRating() {
        return sleepRating;
    }

    public void setSleepRating(final Integer sleepRating) {
        this.sleepRating = sleepRating;
    }


    public String getDescription() {
        return description.trim();
    }

    public void setDescription(final String description) {
        this.description = (description == null) ? "" : description.trim();
    }

}

