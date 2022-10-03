package com.cltwo.cldong.reply.repository;

import com.cltwo.cldong.reply.entity.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    public Page<Reply> findAllByBid(Pageable pageable,Long bid);
}
