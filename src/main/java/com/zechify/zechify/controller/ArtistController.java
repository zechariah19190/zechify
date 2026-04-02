package com.zechify.zechify.controller;


import com.zechify.zechify.entity.Artist;
import com.zechify.zechify.entity.Song;
import com.zechify.zechify.repository.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ArtistController {

    private final ArtistRepository artistRepository;


    @PostMapping
    @CacheEvict(allEntries = true)
    public ResponseEntity<Artist> addArtist(@RequestBody Artist artist){
        Artist savedArtist = artistRepository.save(artist);
        return ResponseEntity.ok(savedArtist);
    }

    @GetMapping("/{id}/songs")
    public List<Song> getSongs(@PathVariable Long id){
        Artist artist = artistRepository.getById(id);

        return artist.getSongs();
    }

    @GetMapping
    public List<Artist> getAllArtists(){
        return artistRepository.findAll();
    }

}
