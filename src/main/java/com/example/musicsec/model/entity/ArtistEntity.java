package com.example.musicsec.model.entity;

import com.google.gson.annotations.Expose;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "artists")
public class ArtistEntity extends BaseEntity {
    @Expose
    @Column(name = "name")
    private String name;
    @Expose
    @Column(name = "career_information",columnDefinition = "TEXT")
    private String careerInformation;


    public String getName () {
        return name;
    }

    public ArtistEntity setName (String name) {
        this.name = name;
        return this;
    }


    public String getCareerInformation () {
        return careerInformation;
    }

    public ArtistEntity setCareerInformation (String careerInformation) {
        this.careerInformation = careerInformation;
        return this;
    }

    public ArtistEntity () {
    }
}
