package com.example.musicsec.model.entity;

import com.example.musicsec.model.enums.Genre;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "albums")
public class AlbumEntity extends BaseEntity {
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, name = "image_url")
    private String imageUrl;
    @Column(nullable = false, name = "video_url")
    private String videoUrl;
    @Column(nullable = false, name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(nullable = false, name = "copies")
    private Integer copies;
    @Column(nullable = false, name = "price")
    private BigDecimal price;
    @Column(nullable = false, name = "release_date")
    private Instant releaseDate;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @ManyToOne
    private ArtistEntity artist;
    @ManyToOne
    private UserEntity owner;

    public Genre getGenre () {
        return genre;
    }

    public AlbumEntity setGenre (Genre genre) {
        this.genre = genre;
        return this;
    }

    public ArtistEntity getArtist () {
        return artist;
    }

    public AlbumEntity setArtist (ArtistEntity artist) {
        this.artist = artist;
        return this;
    }

    public UserEntity getOwner () {
        return owner;
    }

    public AlbumEntity setOwner (UserEntity owner) {
        this.owner = owner;
        return this;
    }

    public String getName () {
        return name;
    }

    public AlbumEntity setName (String name) {
        this.name = name;
        return this;
    }


    public String getImageUrl () {
        return imageUrl;
    }

    public AlbumEntity setImageUrl (String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getVideoUrl () {
        return videoUrl;
    }

    public AlbumEntity setVideoUrl (String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }


    public String getDescription () {
        return description;
    }

    public AlbumEntity setDescription (String description) {
        this.description = description;
        return this;
    }

    public Integer getCopies () {
        return copies;
    }

    public AlbumEntity setCopies (Integer copies) {
        this.copies = copies;
        return this;
    }

    public BigDecimal getPrice () {
        return price;
    }

    public AlbumEntity setPrice (BigDecimal price) {
        this.price = price;
        return this;
    }

    public Instant getReleaseDate () {
        return releaseDate;
    }

    public AlbumEntity setReleaseDate (Instant releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public AlbumEntity () {
    }
}
