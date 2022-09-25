package com.cltwo.cldong.board.dto;

import com.cltwo.cldong.board.entity.Board;
import com.cltwo.cldong.user.entity.User;
import com.cltwo.cldong.video.entity.Video;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDTO {

    private String bid;

//    private User user;
    private Video vid;

    private String uid;
//    private String vid;

    private String bTitle;

    private String bContent;


    public Board toEntity(){
        Board board = Board.builder().bid(bid)
//                .user(user)
//                .video(video)
                .uid(uid)
                .vid(vid)
                .bTitle(bTitle)
                .bContent(bContent)
                .build();
        return board;
    }
}
