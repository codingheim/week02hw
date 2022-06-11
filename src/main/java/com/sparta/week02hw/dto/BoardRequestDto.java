package com.sparta.week02hw.dto;


import lombok.Getter;


@Getter
//@Setter
//@RequeiredArgsConstructor // 왜 사용?
public class BoardRequestDto {
  private Long id;
  private String title;
  private String content;
}
