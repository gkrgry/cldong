package com.cltwo.cldong.video.entity;

import com.cltwo.cldong.board.entity.Board;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "video_tb")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    @Id
    @Column
    private String vid;

    @Column
    private String orgn;

    @Column
    private String size;

    @OneToOne(mappedBy = "vid")//매핑할 변수랑 이름을 똑같이
    private Board board;

    @Column
    @CreationTimestamp
    private LocalDateTime regDate;
}
