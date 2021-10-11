package com.example.musicsec.service.impl;

import com.example.musicsec.model.entity.ArtistEntity;
import com.example.musicsec.repository.ArtistRepository;
import com.example.musicsec.service.ArtistService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final Resource artistFile;
    private final Gson gson;
    private final ArtistRepository artistRepository;

    public ArtistServiceImpl (
            @Value("classpath:/init/artists.json") Resource artistFile,
            Gson gson,
            ArtistRepository artistRepository) {
        this.artistFile = artistFile;
        this.gson = gson;
        this.artistRepository = artistRepository;
    }

    @Override
    public void seedArtists () {
        if (this.artistRepository.count () == 0) {
            try {
                var artists = this.gson
                        .fromJson (Files.readString (Path.of (artistFile.getURI ())),ArtistEntity[].class);
                this.artistRepository.saveAll (Arrays.asList (artists));
            } catch (IOException e) {
                throw new IllegalStateException ("Cannot Seed artists...");
            }
        }

    }
}
