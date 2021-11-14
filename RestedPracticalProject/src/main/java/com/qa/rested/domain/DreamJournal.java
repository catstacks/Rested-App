package com.qa.rested.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "journal")
public final class DreamJournal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "sleep_rating", length = 2, nullable = false)
    private Integer sleepRating;

    @Column(name = "description", length = 500, nullable = true)
    private String description;

    public DreamJournal(
            final Integer id,
            final Integer sleepRating,           
            final String description
    ) {
        this.id = id;
        this.sleepRating = sleepRating; 
        this.description = description;
    }

    public DreamJournal() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
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

