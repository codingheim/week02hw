package com.sparta.week02hw.model;

import com.sparta.week02hw.dto.BoardRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Table(name = "BOARD")
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Entity //JPA가 관리하게 함.
public class Board extends Timestamped {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long _id;

  @Column(nullable = false)
  private String img;

  @Column(nullable = false)
  private String content;

  @Column(nullable = false)
  private int layout;

  // 유저와 게시물 다대일 매핑
  @ManyToOne
  @JoinColumn(name = "User_id")
  private User writer_id;

  //좋아요와 일대다 매핑
//  @OneToMany(mappedBy = "BOARD_ID",cascade = CascadeType.ALL)
//  private final List<Like> likeIds = new ArrayList<>();


  public Board(Long _id, String img, String content, int layout) {
    this._id = _id;
    this.img = img;
    this.content = content;
    this.layout = layout;
  }

  public Board(BoardRequestDto requestDto) {
    this._id = requestDto.get_id();
    this.img = requestDto.getImg();
    this.content = requestDto.getContent();
    this.layout = requestDto.getLayout();
  }

  //변경
  public void update(BoardRequestDto requestDto) {
    this._id = requestDto.get_id();
    this.img = requestDto.getImg();
    this.content = requestDto.getContent();
    this.layout = requestDto.getLayout();
  }

  public void setWriterId(User user) {
    this.writer_id = user;
  }

}
