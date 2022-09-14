package com.cltwo.cldong.user.controller;

import com.cltwo.cldong.user.dto.UserDTO;
import com.cltwo.cldong.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/login")
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public void all(){

    }

    @GetMapping("/manager")
    public void manager(){

    }

    @GetMapping("/admin")
    public void admin(){

    }
    @GetMapping("/join")
    public void join(){

    }

    @ResponseBody
    @PostMapping("/join")
    public String joinP(UserDTO userDTO){

        userService.join(userDTO);
        log.info("아이디 생성" + userDTO.getRole());


        return "redirect:/login/join";

    }


}
