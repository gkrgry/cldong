package com.cltwo.cldong;

import com.cltwo.cldong.board.entity.Board;
import com.cltwo.cldong.board.repository.BoardRepository;
import com.cltwo.cldong.user.entity.User;
import com.cltwo.cldong.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class UserTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;

    @Test
    public void testUser() {
        System.out.println(userRepository.getClass().getName());
    }

    @Test
    public void testUserC() {
        IntStream.rangeClosed(1, 5).forEach(i -> {
            User user = User.builder().uid("test" + i).password("1234").email("test" + i).nickname("test" + i).regDate(LocalDateTime.now()).build();
            userRepository.save(user);
        });
    }


    @Test
    public void testUserR() {
        String user = "test1";

        Optional<User> result = userRepository.findById(user);

        System.out.println("--------------");

        if (result.isPresent()) {
            User user1 = result.get();
            System.out.println(user1);
        }
    }

    @Test
    public void testUserU() {
        User user = User.builder().uid("test1").password("123").build();

    }

    @Test
    public void testUserD() {
        String user = "test5";

        userRepository.deleteById(user);
    }

}
