package com.example.musicsec.repository;

import com.example.musicsec.model.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity,Long> {
}
