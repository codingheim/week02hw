package com.sparta.week02hw.controller;


import com.sparta.week02hw.dto.UserRequestDto;
import com.sparta.week02hw.model.User;
import com.sparta.week02hw.service.UserService;
import org.springframework.web.bind.annotation.*;



@RestController
public class UserController {

  private final UserService userService;


  // @RequiredArgsConstructor
  public UserController(UserService userService) {
    this.userService = userService;
  }

  //회원가입
  @PostMapping("/api/register")
  public String createUser(@RequestBody UserRequestDto requestDto) {
    return userService.createUser();
  }

}


