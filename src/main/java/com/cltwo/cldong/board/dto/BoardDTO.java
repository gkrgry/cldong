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

    private Long bid;

//    private User user;
    private Video vid;

    private String uid;

    private String bTitle;

    private String bContent;


    public Board toEntity(){
        Board board = Board.builder()
//                .user(user)
                .uid(uid)
                .vid(vid)
                .bTitle(bTitle)
                .bContent(bContent)
                .build();
        return board;
    }
}
