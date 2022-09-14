package com.cltwo.cldong.user.repository;

import com.cltwo.cldong.user.dto.UserDTO;
import com.cltwo.cldong.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
