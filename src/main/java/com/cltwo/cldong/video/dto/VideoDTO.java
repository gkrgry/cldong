package com.cltwo.cldong.video.dto;

import com.cltwo.cldong.video.entity.Video;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoDTO {


    private String vid;

    private String orgn;

    private String size;

    public Video toEntity(){
        Video video = Video.builder()
                .vid(vid)
                .orgn(orgn)
                .size(size)
                .build();
        return video;
    }
}
