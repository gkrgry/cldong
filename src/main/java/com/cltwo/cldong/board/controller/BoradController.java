package com.cltwo.cldong.board.controller;

import com.cltwo.cldong.board.dto.BoardDTO;
import com.cltwo.cldong.board.entity.Board;
import com.cltwo.cldong.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
@Log4j2
public class BoradController {

    private final BoardService boardService;

    @GetMapping("/")
    public String main(){

        return "main";
    }


    @ResponseBody
    @PostMapping("/register")
    public String register(BoardDTO boardDTO){

        boardService.bRegister(boardDTO);

        log.info(boardDTO);

        return "success";
    }

    @ResponseBody
    @PostMapping("/modify")
    public String modify(BoardDTO boardDTO){

        boardDTO.setBTitle("modify");
        boardDTO.setBContent("modify");
        boardService.bRegister(boardDTO);

        log.info(boardDTO);

        return "success";
    }

    @ResponseBody
    @PostMapping("/read")
    public Board read(String bid){
        log.info(bid);

        return boardService.bRead(bid);
    }

    @ResponseBody
    @PostMapping("/remove")
    public String remove(String bid){
        log.info(bid);

        boardService.bRemove(bid);
        return "success";
    }
}
