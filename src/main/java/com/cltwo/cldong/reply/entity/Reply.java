package com.cltwo.cldong.reply.entity;

import com.cltwo.cldong.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Builder
public class Reply {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;

    @Column
    private Long bid;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "uid")
    private User uid;

    @Column
    private String content;

    @Column
    @UpdateTimestamp
    private LocalDateTime modDate;

    @Column
    @CreationTimestamp
    private LocalDateTime regDate;

}
