package com.cltwo.cldong.reply.dto;

import com.cltwo.cldong.reply.entity.Reply;
import com.cltwo.cldong.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReplyDTO {

    private Long rid;

    private Long bid;

    private User uid;

    private String content;


    public Reply toEntity(){
        Reply reply = Reply.builder()
                .rid(rid)
                .bid(bid)
                .uid(uid)
                .content(content)
                .build();
        return reply;
    }
}
