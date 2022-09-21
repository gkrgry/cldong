package com.cltwo.cldong.board.entity;

import com.cltwo.cldong.user.entity.User;
import com.cltwo.cldong.video.entity.Video;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "board_tb")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    @Id
    @Column
    private String bid;
//
//    @ManyToOne
//    @JoinColumn(name = "uid")
//    private User user;
//    @OneToOne
//    @JoinColumn(name = "vid")
//    private Video video;

    @Column
    private String uid;

    @Column
    private String vid;

    @Column
    private String bTitle;

    @Column
    private String bContent;

    @Column
    @UpdateTimestamp
    private LocalDateTime modDate;

    @Column
    @CreationTimestamp
    private LocalDateTime regDate;

}
