package com.sparta.week02hw.service;


import com.sparta.week02hw.dto.BoardRequestDto;
import com.sparta.week02hw.dto.UserRequestDto;
import com.sparta.week02hw.model.Board;
import com.sparta.week02hw.model.User;
import com.sparta.week02hw.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class UserService {

  private final UserRepository userRepository;


  public void createUser(UserRequestDto requestDto) {
    User user = new User(requestDto);
    userRepository.save(user);
  }

  public Boolean loginUser(String email, String pwd){
    System.out.println(email+pwd);
    return userRepository.findByEmailAndPassword(email,pwd);
  }

  public User mypageOfUser(Long _id) {
    return userRepository.findById(_id).orElseThrow(
            () -> new NullPointerException("아이디가 존재하지 않습니다")
    );
  }

  public Long updateBoard(Long _id, UserRequestDto requestDto) {
    User user = userRepository.findById(_id).orElseThrow(
            () -> new NullPointerException("존재하지 않는 게시물입니다.")
    );
    user.update(requestDto);
    return user.get_id();
  }

}
