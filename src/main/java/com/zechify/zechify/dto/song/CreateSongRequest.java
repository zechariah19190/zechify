package com.zechify.zechify.dto.song;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateSongRequest {
    private String title;
    private String filePath;
    private Integer durationSeconds;
    private Long artistId;


}