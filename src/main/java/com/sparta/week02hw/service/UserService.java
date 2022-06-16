package com.sparta.week02hw.service;

import com.sparta.week02hw.dto.RegisterRequestDto;
import com.sparta.week02hw.dto.UserRequestDto;
import com.sparta.week02hw.model.User;
import com.sparta.week02hw.repository.UserRepository;
import com.sparta.week02hw.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserService {

  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;
  private final JwtTokenProvider jwtTokenProvider;


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
            .build()
    );
  }


  public void registerUser(RegisterRequestDto registerDto) {
    String email = registerDto.getEmail();
    // 회원 ID 중복 확인
    Optional<User> found = userRepository.findByEmail(email);
    if (found.isPresent()) {
      throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
    }
    userRepository.save(User.builder()
            .password(passwordEncoder.encode(registerDto.getPassword()))
            .roles(Collections.singletonList("ROLE_USER"))
            .email(email)
            .nickname(registerDto.getNickname())
            .build());
  }

  public String loginUser(UserRequestDto requestDto) {
    User user = userRepository.findByEmail(requestDto.getEmail()).orElseThrow(()
            -> new IllegalArgumentException("잘못된 이메일입니다."));

    if (!passwordEncoder.matches(requestDto.getPassword(), user.getPassword())) {
      throw new IllegalArgumentException("잘못된 비밀번호입니다.");
    }
    return jwtTokenProvider.createToken(user.getName(), user.getRoles());
  }
}
