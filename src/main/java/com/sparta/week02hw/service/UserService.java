package com.sparta.week02hw.service;

import antlr.BaseAST;
import com.sparta.week02hw.dto.UserRequestDto;
import com.sparta.week02hw.model.User;
import com.sparta.week02hw.repository.UserRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository userRepository;


  public void createUser(User requestDto) {
    String email = requestDto.getEmail();
    // 회원 ID 중복 확인
    Optional<User> found = userRepository.findByEmail(email);
    if (found.isPresent()) {
      throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
    }
    userRepository.save(User.builder()
            .name(requestDto.getName())
            .password(passwordEncoder.encode(requestDto.getPassword()))
            .roles(Collections.singletonList("ROLE_USER"))
            .email(email)
            .nickname(requestDto.getNickname())
            .build());
  }
}
