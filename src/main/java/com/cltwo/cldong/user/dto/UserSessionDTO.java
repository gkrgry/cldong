package com.cltwo.cldong.user.dto;

import com.cltwo.cldong.user.entity.Role;
import com.cltwo.cldong.user.entity.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserSessionDTO implements Serializable {
    private String uid;
    private String password;
    private String email;
    private String nickname;
    private Role role;

    public UserSessionDTO(User user){
        this.uid = user.getUid();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
        this.role = user.getRole();
    }
}
