package com.cltwo.cldong.reply.controller;


import com.cltwo.cldong.reply.dto.ReplyDTO;
import com.cltwo.cldong.reply.entity.Reply;
import com.cltwo.cldong.reply.service.ReplyService;
import com.cltwo.cldong.user.entity.User;
import com.cltwo.cldong.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {
    private final ReplyService replyService;

    private final UserService userService;


    @ResponseBody
    @PostMapping("/insert")
    public void insertReply(ReplyDTO replyDTO, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();

        User user = userService.getUserOne((String)session.getAttribute("login"));
        replyDTO.setUid(user);

        Reply reply = replyDTO.toEntity();

        replyService.ReplyInsert(reply);
    }

    @ResponseBody
    @GetMapping("/read")
    public Page<Reply> insertReply(Model model,
                                   Long bid,
                                   @PageableDefault(sort = "regDate", direction = Sort.Direction.DESC, size = 10) Pageable pageable) throws Exception {
        Page<Reply> replyPage = replyService.pageReply(pageable, bid);



        return replyPage;
    }

    @ResponseBody
    @DeleteMapping("/remove")
    public String deleteReply(Long rid) throws Exception {
        if (true) {
            replyService.ReplyRemove(rid);
            return "success reply remove";
        }

        return "fail";
    }
}
