package com.sparta.week02hw.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDto {
  private String name;
  private String nickname;
  private String password;
  private String email;
}
