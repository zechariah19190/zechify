package com.zechify.zechify.controller;


import com.zechify.zechify.dto.song.CreateSongRequest;
import com.zechify.zechify.entity.Artist;
import com.zechify.zechify.repository.ArtistRepository;
import com.zechify.zechify.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import com.zechify.zechify.entity.Song;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import com.zechify.zechify.service.SongService;


@RestController
@RequestMapping("/songs")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class SongController {

    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;


    @PostMapping
    public Song createSong(@RequestBody CreateSongRequest request) {
        Artist artist = artistRepository.findById(request.getArtistId())
                .orElseThrow(() -> new RuntimeException("Artist not found"));

        Song song = Song.builder()
                .title(request.getTitle())
                .filePath(request.getFilePath())
                .durationSeconds(request.getDurationSeconds())
                .artist(artist)
                .build();

        return songRepository.save(song);

    }




    @GetMapping("/{id}")
    public ResponseEntity<Song> getSong(@PathVariable Long id){
        Optional<Song> song = songRepository.findById(id);
        return song.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }


    @GetMapping("artist/{id}")
    public List<Song> getArtistSongs(@PathVariable Long id){
        Optional<Artist> artist = artistRepository.findById(id);
        return artist.get().getSongs();
    }

    @GetMapping
    public List<Song> getAllSongs(){
        return songRepository.findAll();
    }

    @GetMapping("/{id}/stream")
    public ResponseEntity<Resource> streamSong(@PathVariable Long id){
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Song not found"));

        try {
            Path path = Paths.get(song.getFilePath());
            Resource resource = new UrlResource(path.toUri());

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("audio/mpeg"))
                    .body(resource);

        } catch (MalformedURLException e) {
            throw new RuntimeException("Error streaming file", e);
        }
    }


}
