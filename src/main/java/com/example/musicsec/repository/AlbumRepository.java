package com.example.musicsec.repository;

import com.example.musicsec.model.entity.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity,Long> {
}
