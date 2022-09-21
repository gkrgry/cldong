package com.cltwo.cldong.board.controller;

import com.cltwo.cldong.board.dto.BoardDTO;
import com.cltwo.cldong.board.entity.Board;
import com.cltwo.cldong.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping({"/main","/"})
    public String main(Model model,
                       @PageableDefault(sort = "bid",direction = Sort.Direction.DESC, size = 12)Pageable pageable){
        Page<Board> list = boardService.pageList(pageable);
        model.addAttribute("pageable",list);//내용
        model.addAttribute("prev",pageable.previousOrFirst().getPageNumber());//이전페이지
        model.addAttribute("next",pageable.next().getPageNumber());//다음페이지
        model.addAttribute("hasPrev",list.hasPrevious());//이전페이지가 있냐
        model.addAttribute("hasNext",list.hasNext());//다음페이지가 있냐
        model.addAttribute("pageNum",pageable.getPageNumber());
        model.addAttribute("totalPage",list.getTotalPages());


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
