package com.webite.crossplatform.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "statuses")
public class StatusesEntity {

    @Id
    @Column(name = "status_id")
    private Long id;

    private String description;

    public StatusesEntity(long l) {
        this.id = l;
    }

    // getters and setters for all fields
}