package com.cltwo.cldong.board.service;

import com.cltwo.cldong.board.dto.BoardDTO;
import com.cltwo.cldong.board.entity.Board;
import com.cltwo.cldong.board.repository.BoardRepository;
import com.cltwo.cldong.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public String bRegister(BoardDTO boardDTO){

        return boardRepository.save(boardDTO.toEntity()).getBid();

    }

    public void bRemove(String bid){
        boardRepository.deleteById(bid);
    }


    public Board bRead(String bid){
        Optional<Board> result = boardRepository.findById(bid);
        if(result.isPresent()){
            Board board = result.get();

            return board;

        }
        return null;
    }
}
