package com.cltwo.cldong.user.service;

import com.cltwo.cldong.user.dto.UserDTO;
import com.cltwo.cldong.user.entity.User;
import com.cltwo.cldong.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Log4j2
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder encoder;

    @Transactional
    public String join(UserDTO dto) {
        dto.setPassword(encoder.encode(dto.getPassword()));
        return userRepository.save(dto.toEntity()).getUid();
    }

    public User getUserOne(String uid) {
        return userRepository.findById(uid).orElseThrow(() -> new NullPointerException("없는 아이디 입니다."));
    }

    public int selectEmail(String email) {
        return userRepository.findUserEmailByEmail(email);
    }

    public String modifyUser(String uid, String nickname, String password) {
        if (uid == null || uid.equals("")) {
            return "id 가 비였습니다.";
        } else if (password == null || password.equals("")) {
            return "password가 비였습니다.";
        } else if (nickname == null || nickname.equals("")) {
            return "nickname이 비였습니다.";
        } else {
            User user = getUserOne(uid);
            UserDTO userDTO = UserDTO.builder()
                    .uid(user.getUid())
                    .password(password)
                    .nickname(nickname)
                    .email(user.getEmail())
                    .build();
            userRepository.save(userDTO.toEntity());
            return "유저 정보가 변경되었습니다.";
        }

    }


}
