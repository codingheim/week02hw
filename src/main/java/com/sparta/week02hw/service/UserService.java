package com.sparta.week02hw.service;


import com.sparta.week02hw.dto.RegisterRequestDto;
import com.sparta.week02hw.dto.UserRequestDto;
import com.sparta.week02hw.jwt.JwtTokenProvider;
import com.sparta.week02hw.model.User;
import com.sparta.week02hw.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;


@Service

public class UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtTokenProvider jwtTokenProvider;

  @Autowired
  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtTokenProvider = jwtTokenProvider;
  }

  public void registerUser(RegisterRequestDto registerRequestDto) {
    String email = registerRequestDto.getEmail();
    Optional<User> found = userRepository.findByEmail(email);
    if (found.isPresent()) {
      throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
    }
    userRepository.save(User.builder()
            .password(passwordEncoder.encode(registerRequestDto.getPassword()))
            .roles(Collections.singletonList("ROLE_USER"))
            .email(email)
            .nickname(registerRequestDto.getNickname())
            .build());
  }

  public String loginUser(UserRequestDto userDto) {
    User user = userRepository.findByEmail(userDto.getEmail())
            .orElseThrow(() -> new IllegalArgumentException("ID를 찾을 수 없습니다."));
    if(!passwordEncoder.matches(userDto.getPassword(),user.getPassword())){
      throw new IllegalArgumentException("잘못된 비밀번호입니다.");
    }
    return jwtTokenProvider.createToken(user.getEmail(), user.getRoles());
  }

}