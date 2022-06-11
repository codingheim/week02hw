package com.sparta.week02hw.model;

import com.sparta.week02hw.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity //테이블 생성
public class Board extends Timestamped{
  @GeneratedValue(strategy = GenerationType.AUTO) //Auto 와 IDENTITY 차이
  @Id
  @Column(name = "BOARD_ID")
  private Long id;

  @OneToMany(mappedBy = "user")
  @JoinColumn(name = "USER_ID")
  private User userid;
  //보드와 유저의 관계 일대다

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String content;

  public Board(String title, String content) {
    this.title = title;
    this.content = content;

  }

  public Board(BoardRequestDto requestDto) {
    this.title = requestDto.getTitle();
    this.content = requestDto.getContent();
  }

  public void update(BoardRequestDto requestDto) {
    this.title = requestDto.getTitle();
    this.content = requestDto.getContent();
  }
}
