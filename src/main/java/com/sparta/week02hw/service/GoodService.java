package com.sparta.week02hw.service;


import com.sparta.week02hw.model.Board;
import com.sparta.week02hw.model.Good;
import com.sparta.week02hw.model.User;
import com.sparta.week02hw.repository.BoardRepository;
import com.sparta.week02hw.repository.GoodRepository;
import com.sparta.week02hw.repository.UserRepository;
import com.sparta.week02hw.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoodService {

  private final BoardRepository boardRepository;
  private final UserRepository userRepository;
  private final GoodRepository goodRepository;

  public String findGood(Long boardId, UserDetailsImpl userDetailsImpl){
    User user = userRepository.findByEmail(userDetailsImpl.getUsername()).orElseThrow(
            () -> new NullPointerException("해당 유저를 찾을 수 없습니다.")
    );
    Board board = boardRepository.findById(boardId).orElseThrow(
            () -> new NullPointerException("게시글 ID를 찾을 수 없습니다.")
    );

    Optional<Good> optionalLikes = goodRepository.findByBoardAndUser(board, user);

    if (optionalLikes.isPresent()){
      goodRepository.delete(optionalLikes.get());

      return "좋아요취소";
    }else{
      Good good = new Good(user, board);
      goodRepository.save(good);

      return "좋아요";
    }

  }


}

