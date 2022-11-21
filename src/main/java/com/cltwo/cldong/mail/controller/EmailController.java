package com.cltwo.cldong.mail.controller;

import com.cltwo.cldong.mail.service.EmailService;
import com.cltwo.cldong.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
@Log4j2
public class EmailController {

    private final EmailService emailService;

    private final UserService userService;

    @ResponseBody
    @PostMapping("/emailConfirm")
    public ResponseEntity<?> emailConfirm(String floatingInputEmail) throws Exception {

        int overlapCheck = userService.selectEmail(floatingInputEmail);
        if (overlapCheck > 0) {
            return ResponseEntity.status(401).body("이미 존재하는 이메일 입니다.");
        }
        String confirm = emailService.sendSimpleMessage(floatingInputEmail);

        log.info(confirm);


        return ResponseEntity.status(200).body("메일을 보냈습니다.");
    }

}
