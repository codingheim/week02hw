package com.sparta.week02hw.service;


import com.sparta.week02hw.dto.BoardRequestDto;
import com.sparta.week02hw.model.Board;
import com.sparta.week02hw.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

  private final BoardRepository boardRepository;

  //생성
  public void createBoard(Board board) {
    boardRepository.save(board);
  }

  //조회
  public List<Board> getBoards() {
    return boardRepository.findAllByOrderByModifiedAtDesc();
  }

  //변경
  @Transactional //이거?
  public Long update(Long _id, BoardRequestDto requestDto) {
    Board board = boardRepository.findById(_id).orElseThrow(
            () -> new NullPointerException("해당 게시물이 존재하지 않습니다.")
    );
    board.update(requestDto);
    return board.get_id();
  }

  public void deleteBoard(Long _id) {
    boardRepository.deleteById(_id);
  }
}
