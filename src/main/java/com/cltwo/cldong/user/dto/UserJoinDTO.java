package com.cltwo.cldong.user.dto;

import com.cltwo.cldong.user.entity.Role;
import com.cltwo.cldong.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserJoinDTO {

    private String uid;

    private String nickname;

    //dto -> entity

    public User toEntity() {
        User user = User.builder().uid(uid)
                .nickname(nickname)
                .build();
        return user;
    }

    ;

}
