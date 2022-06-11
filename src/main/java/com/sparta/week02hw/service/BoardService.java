package com.sparta.week02hw.service;


import com.sparta.week02hw.dto.BoardRequestDto;
import com.sparta.week02hw.model.Board;
import com.sparta.week02hw.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

  private final BoardRepository boardRepository; //무조건 필요하다 의미를 가지며, Repository
  //create
  public Board writeBoard(Board board) {
    return boardRepository.save(board);
  }
  //read
  public List<Board> getBoards() {
    return boardRepository.findAllByOrderByModifiedAtDesc();
  }

  public Board getBoard(@PathVariable Long boardid) {
    return boardRepository.findById(boardid).orElseThrow(
            () -> new NullPointerException("해당 게시물이 존재하지 않습니다.")
    );
  }
  // 의도한 하나의 논리적인 데이터들을 보내겠다.
  @Transactional
  //update
  public Long update(Long id, BoardRequestDto requestDto) {
    Board board = boardRepository.findById(id).orElseThrow(
            () -> new NullPointerException("존재하는 게시물이 없습니다.") //예외처리
    );
    board.update(requestDto); //이 부분의 연결고리
    return board.getId();
  }
  //delete
  public void delete(Long boardid) {
    boardRepository.deleteById(boardid);
  }

}
