package com.cltwo.cldong.user.controller;

import com.cltwo.cldong.user.dto.UserDTO;
import com.cltwo.cldong.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/")
public class UserController {

    private final UserService userService;

//    @GetMapping("/all")
//    public void all(){
//
//    }
//
//    @PreAuthorize("hasRole('MEMBER')")
//    @GetMapping("/member")
//    public void member(){
//
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/admin")
//    public void admin(){
//
//    }

    @GetMapping("/login")
    public String login(Principal principal) throws Exception{
        if(principal != null){
            return "redirect:/";
        }
        return "login";
    }

    @GetMapping("/join")
    public void join(){

    }

    @PostMapping("/join")
    public String joinP(UserDTO userDTO){

        userService.join(userDTO);
        log.info("아이디 생성" + userDTO.getRole());


        return "redirect:/";

    }




}
