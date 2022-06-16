package com.sparta.week02hw.dto;

import com.sparta.week02hw.model.Good;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GoodRequestDto {

  private final String user_email;
  private final String user_nickname;

  public GoodRequestDto(Good good) {
    this.user_email = good.getUser().getEmail();
    this.user_nickname = good.getUser().getNickname();
  }
}
