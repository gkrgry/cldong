package com.cltwo.cldong.user.service;

import com.cltwo.cldong.user.entity.User;
import com.cltwo.cldong.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
        User user = userRepository.findById(uid).orElseThrow(() ->
                new UsernameNotFoundException("해당사용자가 없습니다."));
        return new CustomUserDetais(user);
    }
}
