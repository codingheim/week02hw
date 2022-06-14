package com.sparta.week02hw.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UserRequestDto {

  private Long _id;
  private String name;
  private String nickname;
  private String email;
  private String password;

}
