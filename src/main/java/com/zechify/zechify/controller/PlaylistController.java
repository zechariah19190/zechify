package com.zechify.zechify.controller;


import com.zechify.zechify.entity.Playlist;
import com.zechify.zechify.repository.PlaylistRepository;
import lombok.NoArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
public class PlaylistController {

    /*
    private final PlaylistRepository playlistRepository;


    @PostMapping
    @CacheEvict(allEntries = true)
    public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist){
        Playlist savedPlaylist = playlistRepository.save(playlist);
        return ResponseEntity.ok(savedPlaylist);

    }
*/

}