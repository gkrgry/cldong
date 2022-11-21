package com.cltwo.cldong.reply.service;

import com.cltwo.cldong.board.entity.Board;
import com.cltwo.cldong.reply.entity.Reply;
import com.cltwo.cldong.reply.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyRepository replyRepository;

    public void ReplyInsert(Reply reply) {
        replyRepository.save(reply);
    }

    public void ReplyRemove(Long rid) {
        replyRepository.deleteById(rid);
    }

    public Page<Reply> pageReply(Pageable pageable, Long bid) {
        return replyRepository.findAllByBid(pageable, bid);
    }
}
