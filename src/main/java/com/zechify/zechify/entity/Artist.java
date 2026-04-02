package com.zechify.zechify.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artists")
@Data
public class Artist {
    @Id @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "artist")
    @JsonManagedReference
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song){
        songs.add(song);
        song.setArtist(this);
    }

}
