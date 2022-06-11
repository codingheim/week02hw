package com.sparta.week02hw.service;

import com.sparta.week02hw.dto.RegisterRequestDto;
import com.sparta.week02hw.model.User;
import com.sparta.week02hw.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

  private final UserRepository userRepository;

  //=@RequiredArgsConstructor 과 같음
  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }


  public void registerUser(RegisterRequestDto requestDto) {
    String name = requestDto.getName();
    //repository와 연결
    Optional<User> found = userRepository.findByname(name);
    if (found.isPresent()) {
      throw new NullPointerException("중복된 사용자 ID가 존재합니다.");
    }

    //패스워드 암호화
    String email = requestDto.getEmail();

    //@Setter 연결
    User user = new User(name,nickname,password,email);
    userRepository.save(user);
  }


}
