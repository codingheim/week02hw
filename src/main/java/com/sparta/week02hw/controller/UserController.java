package com.sparta.week02hw.controller;

import com.sparta.week02hw.dto.RegisterRequestDto;
import com.sparta.week02hw.dto.UserRequestDto;
import com.sparta.week02hw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }


  @PostMapping("/api/login")
  public String loginUser(@Validated @RequestBody UserRequestDto requestDto) {
    return userService.loginUser(requestDto);
  }

  @PostMapping("/api/register")
  public void registerUser(@Validated @RequestBody RegisterRequestDto requestDto){
    requestDto.checkPassword();
    userService.registerUser(requestDto);
  }

}


