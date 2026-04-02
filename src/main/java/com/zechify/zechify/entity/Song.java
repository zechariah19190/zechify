package com.zechify.zechify.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.ErrorResponse;

import java.util.List;

@Entity
@Table(name = "songs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Song {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private Integer durationSeconds;
    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false)
    @JsonBackReference
    private Artist artist;

    @Transient
    private Long artistId;


    @Transient
    public String getArtistName() {
        return artist != null ? artist.getName() : null;
    }

}
