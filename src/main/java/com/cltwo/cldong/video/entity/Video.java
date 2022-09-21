package com.cltwo.cldong.video.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private String name;

    @Column
    private String vol;

    @Column
    private String tag;

    @Column
    private String size;

    @Column
    @CreationTimestamp
    private LocalDateTime regDate;
}
