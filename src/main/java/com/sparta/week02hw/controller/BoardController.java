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

  @PostMapping("api/boards")
  public Board createBoard(@RequestBody BoardRequestDto requestDto) {
    Board board = new Board(requestDto);
    return boardService.writeBoard(board);
  }

  @GetMapping("/api/boards")
  public List<Board> getBoards() {
    return boardService.getBoards();
  }

  @GetMapping("/api/boards/{boardid}")
  public Board getBoard(@PathVariable Long boardid) {
    return boardService.getBoard(boardid);
  }

  @PutMapping("/api/board/{boardid}")
  public Long updateBoard(@PathVariable Long boardid, @RequestBody BoardRequestDto requestDto) {
    boardService.update(boardid,requestDto);
    return boardid;
  }

  @DeleteMapping("/api/board/{boardid}")
  public Long deleteBoard(@PathVariable Long boardid) {
    boardService.delete(boardid);
    return boardid;
  }
}

