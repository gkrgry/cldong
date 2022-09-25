package com.cltwo.cldong.video.controller;

import com.cltwo.cldong.video.dto.VideoDTO;
import com.cltwo.cldong.video.service.S3Service;
import com.cltwo.cldong.video.service.VideoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/video")
public class VideoController {

    private final VideoService videoService;
    private final S3Service s3Service;


    @PostMapping("/upload")
    public String videoUpload(MultipartFile videoFile){
        String id = randomId();

        videoService.videoS3Register(videoFile,id);
        s3Service.uploadFile(videoFile,id);

        return "success";
    }

    @PostMapping("/remove")
    public String videoUpload(String filename){
        videoService.videoDelete(filename);
        s3Service.deleteFile(filename);

        return "remove success";
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
