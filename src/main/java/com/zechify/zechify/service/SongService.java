package com.zechify.zechify.service;

import com.zechify.zechify.dto.song.CreateSongRequest;
import com.zechify.zechify.dto.song.SongResponse;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SongService {
    List<SongResponse> getAllSongs();
    SongResponse getSongById(Long id);
    SongResponse createSong(CreateSongRequest request);
    void deleteSong(Long id);
    List<SongResponse> getSongsByArtist(Long artistId);
    ResponseEntity<Resource> streamSong(Long id);
}
