package com.sparta.week02hw.service;


import com.sparta.week02hw.dto.BoardRequestDto;
import com.sparta.week02hw.model.Board;
import com.sparta.week02hw.model.User;
import com.sparta.week02hw.repository.BoardRepository;
import com.sparta.week02hw.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;



@AllArgsConstructor
@Service
@Transactional
public class BoardService {

  private final BoardRepository boardRepository;
  private final UserRepository userRepository;

  //조회
  public List<Board> getBoards() {
    return boardRepository.findAllByOrderByModifiedAtDesc(); //최신순 (시간최근순)
  }

  //게시물 단일 조회
  public Board getBoard(Long _id) {
    return boardRepository.findById(_id).orElseThrow(
            () -> new NullPointerException("존재하는 게시물이 없습니다.")
    );
  }


  //생성
  public void createBoards(Board requestDto) {
    User user = userRepository.findById(requestDto.get_id()).orElseThrow(
            ()-> new NullPointerException("존재하지 않는 아이디입니다.")
    );
    Board board = new Board();
    user.createBoards(board);
    boardRepository.save(board);
  }

  //변경
  public Long updateBoard(Long _id, BoardRequestDto requestDto) {
    Board board = boardRepository.findById(_id).orElseThrow(
            () -> new NullPointerException("존재하지 않는 게시물입니다.")
    );
    board.update(requestDto);
    return board.get_id();
  }

  //삭제
  public void deleteBoard(Long _id) {
    boardRepository.deleteById(_id);
  }

}
