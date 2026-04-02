package com.zechify.zechify.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="playlist")
@Data
@Builder
@Getter
@Setter
public class Playlist {
    @Id @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    private List<Song> songs;

}
