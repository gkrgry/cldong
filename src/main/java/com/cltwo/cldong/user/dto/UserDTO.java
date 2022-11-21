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
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO implements UserDetails {

    private String uid;

    private String password;

    private String email;

    private String nickname;

    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(role.getValue()));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getUsername() {
        return uid;
    }


    //dto -> entity

    public User toEntity() {
        User user = User.builder().uid(uid)
                .password(password)
                .nickname(nickname)
                .email(email)
//                .role(Role.USER)
                .role(Role.MEMBER)
//                .role(Role.ADMIN)
                .build();
        return user;
    }

    ;

}
