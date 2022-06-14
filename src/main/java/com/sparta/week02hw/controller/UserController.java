package com.sparta.week02hw.controller;


import com.sparta.week02hw.dto.UserRequestDto;
import com.sparta.week02hw.model.User;
import com.sparta.week02hw.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/api/register")
  public void createUser(@RequestBody UserRequestDto requestDto) {
    userService.createUser(requestDto);
  }

  @PostMapping("/api/login")
  public Boolean userLogin(@RequestBody UserRequestDto requestDto) {
    return userService.loginUser(requestDto.getEmail(), requestDto.getPassword());    //
  }

  @GetMapping("/api/mypage/{userId}")
  public User mypageOfUser(@PathVariable Long userId) {
    return new User();
  }
}
