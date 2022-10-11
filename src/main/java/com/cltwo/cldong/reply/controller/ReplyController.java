package com.cltwo.cldong.reply.controller;


import com.cltwo.cldong.reply.dto.ReplyDTO;
import com.cltwo.cldong.reply.entity.Reply;
import com.cltwo.cldong.reply.service.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {
    private final ReplyService replyService;


    @ResponseBody
    @PostMapping("/insert")
    public void insertReply(ReplyDTO replyDTO, Principal principal) throws Exception {

        replyDTO.setUid(principal.getName());

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
