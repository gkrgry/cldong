package com.cltwo.cldong.board.controller;

import com.cltwo.cldong.board.dto.BoardDTO;
import com.cltwo.cldong.board.entity.Board;
import com.cltwo.cldong.board.service.BoardService;
import com.cltwo.cldong.user.entity.User;
import com.cltwo.cldong.user.service.UserService;
import com.cltwo.cldong.video.dto.VideoDTO;
import com.cltwo.cldong.video.entity.Video;
import com.cltwo.cldong.video.service.S3Service;
import com.cltwo.cldong.video.service.VideoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
@Log4j2
public class BoardController {

    private final BoardService boardService;
    private final UserService userService;
    private final VideoService videoService;
    private final S3Service s3Service;

    @GetMapping({"/main","/"})
    public String main(Model model,
                       @PageableDefault(sort = "bid",direction = Sort.Direction.DESC, size = 12)Pageable pageable,
                       Principal principal,
                       HttpServletRequest request) throws Exception{
        Page<Board> list = boardService.pageList(pageable);
        model.addAttribute("pageable",list);//내용
        model.addAttribute("prev",pageable.previousOrFirst().getPageNumber());//이전페이지
        model.addAttribute("next",pageable.next().getPageNumber());//다음페이지
        model.addAttribute("hasPrev",list.hasPrevious());//이전페이지가 있냐
        model.addAttribute("hasNext",list.hasNext());//다음페이지가 있냐
        model.addAttribute("pageNum",pageable.getPageNumber());
        model.addAttribute("totalPage",list.getTotalPages());

        if(principal != null){
            HttpSession session = request.getSession();
            session.setAttribute("login",principal.getName());
            log.info(principal.getName());
        }

        return "main";
    }


    @GetMapping("/register")
    public String boardRegister(){


        return "board";
    }
    @PostMapping("/register")
    public String register(BoardDTO boardDTO, MultipartFile uploadfile, Principal principal) throws Exception{


        User user = userService.getUserOne(principal.getName());
        String vid = randomId();
        VideoDTO videoDTO = videoService.videoToEmtity(uploadfile,vid);


        videoUpload(uploadfile,vid);
        boardDTO.setUid(user);
        boardDTO.setVid(videoDTO.toEntity());
        boardService.bRegister(boardDTO);
        log.info("---------------------------------------------test111");

        return "redirect:/main";
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
    public Board read(Long bid){
        log.info(bid);

        return boardService.bRead(bid);
    }

    @ResponseBody
    @PostMapping("/remove")
    public String remove(Long bid){
        String vid = boardService.bRead(bid).getVid().getVid();

        boardService.bRemove(bid);
        videoDelete(vid);
        return "success";
    }

    @GetMapping("/video")
    public String video(String vid,Long bid,Model model){
        Board board = boardService.bRead(bid);
        model.addAttribute("bid",board.getBid());
        model.addAttribute("uid",board.getUid().getUid());
        model.addAttribute("bTitle",board.getBTitle());
        model.addAttribute("bContent",board.getBContent());
        model.addAttribute("vid",vid);

        return "video";
    }

    //db, s3 파일 업로드
    public void videoUpload(MultipartFile videoFile,String vid){
        videoService.videoS3Register(videoFile,vid);
        s3Service.uploadFile(videoFile,vid);
    }


    //파일 삭제
    public void videoDelete(String filename){
        videoService.videoDelete(filename);
        s3Service.deleteFile(filename);
    }

    public String randomId(){
        UUID uuid = UUID.randomUUID();
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd");
        String formatedNow = now.format(formatter);
        String rId = formatedNow+"_"+uuid.toString();
        return rId;
    }
}
