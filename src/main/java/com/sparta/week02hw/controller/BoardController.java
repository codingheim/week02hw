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


  @PostMapping("/api/boards")
  public Board createBoard(@RequestBody BoardRequestDto requestDto) {
    Board board = new Board(requestDto);
    boardService.createBoards(board);
    return board;
  }

  @GetMapping("/api/boards")
  public List<Board> getBoards() {
    return boardService.getBoards();
  }

  @GetMapping("/api/boards/{_id}")
  public Board getBoard(@PathVariable Long _id) {
    return boardService.getBoard(_id);
  }

  @PutMapping("/api/boards/{_id}")
  public Long updateBoard(@PathVariable Long _id, @RequestBody BoardRequestDto requestDto) {
    return boardService.updateBoard(_id, requestDto);
  }

  @DeleteMapping("/api/boards/{_id}")
  public Long deleteboard(@PathVariable Long _id) {
    boardService.deleteBoard(_id);
    return _id;
  }


}
