package com.cltwo.cldong.reply.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reply_tb")
@Getter
@ToString
@Builder
public class Reply {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;

    @Column
    private Long bid;

    @Column
    private String uid;

    @Column
    private String content;

    @Column
    @UpdateTimestamp
    private LocalDateTime modDate;

    @Column
    @CreationTimestamp
    private LocalDateTime regDate;

}
