package com.sparta.week02hw.controller;


import com.sparta.week02hw.dto.RegisterRequestDto;
import com.sparta.week02hw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {


  private final UserService userService;


  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  //회원 로그인 페이지
  @GetMapping("/api/login")
  public String login() {
    return "login";
  }

  //회원가입 페이지
  @PostMapping("/api/register")
  public String registerUser(RegisterRequestDto requestDto) {
    userService.registerUser(requestDto);
    return "redirect:/user/login";
  }

}
