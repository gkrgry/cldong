package com.cltwo.cldong.board.service;

import com.cltwo.cldong.board.dto.BoardDTO;
import com.cltwo.cldong.board.entity.Board;
import com.cltwo.cldong.board.repository.BoardRepository;
import com.cltwo.cldong.user.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardService {

    private final BoardRepository boardRepository;

    public String bRegister(BoardDTO boardDTO){

        return boardRepository.save(boardDTO.toEntity()).getBid().toString();

    }

    public void bRemove(Long bid){
        boardRepository.deleteById(bid);
    }


    public Board bRead(Long bid){
        Optional<Board> result = boardRepository.findById(bid);

        if(result.isPresent()){
            Board board = result.get();
            return board;
        }
        return null;
    }

    public Page<Board> pageList(Pageable pageable){
        return boardRepository.findAll(pageable);
    }
}
