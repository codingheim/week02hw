package com.sparta.week02hw.controller;


import com.sparta.week02hw.dto.BoardRequestDto;
import com.sparta.week02hw.model.Board;
import com.sparta.week02hw.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardController {

  private final BoardService boardService;

  //Dto에서 가져 온 값
  @PostMapping("/api/boards")
  public void creatBoard(@RequestBody BoardRequestDto requestDto) {
    Board board = new Board(requestDto);
    //Service로 보내기
    boardService.createBoard(board);
  }

  @GetMapping("/api/boards")
  public List<Board> getBoards() {
    return boardService.getBoards();
  }

  @PutMapping("/api/boards/{_id}")
  public Long updateBoard(@PathVariable Long _id, @RequestBody BoardRequestDto requestDto) {
    boardService.update(_id,requestDto);
    return _id;
  }

  @DeleteMapping("/api/boards/{_id}")
  public Long deleteBoard(@PathVariable Long _id) {
    boardService.deleteBoard(_id);
    return _id;
  }
}
