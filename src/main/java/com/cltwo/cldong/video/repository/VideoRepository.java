package com.cltwo.cldong.video.repository;

import com.cltwo.cldong.video.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, String> {
}
