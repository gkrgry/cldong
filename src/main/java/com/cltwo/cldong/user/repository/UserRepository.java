package com.cltwo.cldong.user.repository;

import com.cltwo.cldong.user.dto.UserDTO;
import com.cltwo.cldong.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

    @Query("select count(email) from User")
    public int findUserEmailByEmail(String email);

}
