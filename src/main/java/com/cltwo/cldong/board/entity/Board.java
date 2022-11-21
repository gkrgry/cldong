package com.cltwo.cldong.board.entity;

import com.cltwo.cldong.user.entity.User;
import com.cltwo.cldong.video.entity.Video;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bid;
    //
//    @ManyToOne
//    @JoinColumn(name = "uid")
//    private User user;
    @OneToOne
    @JoinColumn(name = "vid")
    @JsonIgnore
    private Video vid;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "uid")
    private User uid;

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
