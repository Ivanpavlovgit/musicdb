package com.example.musicsec.model.entity;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, updatable = false)
    private long id;

    public long getId () {
        return id;
    }

    public BaseEntity setId (long id) {
        this.id = id;
        return this;
    }

    public BaseEntity () {
    }
}
