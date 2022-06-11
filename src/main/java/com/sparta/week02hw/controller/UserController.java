package com.sparta.week02hw.controller;


import com.sparta.week02hw.dto.RegisterRequestDto;
import com.sparta.week02hw.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

  private UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  //회원 로그인 페이지
  @GetMapping("/api/login")
  public String login() {
    return "login";
  }

  @PostMapping("/api/register")
  public String registerUser(RegisterRequestDto requestDto) {
    userService.registerUser(requestDto);
    return "redirect:/user/login";
  }

}
