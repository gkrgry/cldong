package com.cltwo.cldong.video.service;

import com.cltwo.cldong.video.dto.VideoDTO;
import com.cltwo.cldong.video.entity.Video;
import com.cltwo.cldong.video.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;

    

    //동영상 파일 저장
    public String videoS3Register(MultipartFile videoFile,String fileName){
        VideoDTO dto = videoToEmtity(videoFile,fileName);

        return videoRepository.save(dto.toEntity()).getVid();
    }

    //동영상 파일 객체 변환
    public VideoDTO videoToEmtity(MultipartFile videoFile,String fileName){
        String orgn = videoFile.getOriginalFilename();
        double size = videoFile.getSize();

        size = size/1024/1024;

        VideoDTO videoDTO = new VideoDTO();

        videoDTO.setVid(fileName);
        videoDTO.setOrgn(orgn);
        videoDTO.setSize(String.format("%.2f",size));
        return videoDTO;
    }

    public void videoDelete(String fileName){
        videoRepository.deleteById(fileName);
    }


}
