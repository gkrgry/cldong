package com.cltwo.cldong.user.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "user_tb")
@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(length = 50)
    private String uid;

    @Column(length = 200, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String nickname;

    @Column(length = 50, nullable = false)
    private String email;

    @Column
    @UpdateTimestamp
    private LocalDateTime modDate;

    @Column
    @CreationTimestamp
    private LocalDateTime regDate;

    @Column(columnDefinition = "varchar(15) default 'USER'")
    private String rol;

}
