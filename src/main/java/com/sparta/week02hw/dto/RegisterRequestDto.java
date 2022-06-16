package com.sparta.week02hw.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class RegisterRequestDto {



  private String email;


  private String password;


  private String nickname;


  public boolean checkPassword() {
    return !this.password.contains(this.email.split("@")[0])
            && !this.password.contains(this.nickname.split("@")[0]);
  }
}
