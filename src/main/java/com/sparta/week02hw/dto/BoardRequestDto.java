package com.sparta.week02hw.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardRequestDto {

  private Long _id;
  private Long writerId;
  private String img;
  private String content;
  private int layout;

}
