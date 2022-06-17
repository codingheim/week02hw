package com.sparta.week02hw.model;


import com.sparta.week02hw.dto.BoardRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "BOARD")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Board extends Timestamped{

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long _id;

  @Column(nullable = false)
  private String img;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String content;

  @Column(nullable = false)
  private int layout;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id",nullable = false)
  private User user;

//  @OneToMany(mappedBy = "board", fetch = FetchType.EAGER, orphanRemoval = true)
//  private List<Good> goodList = new ArrayList<>();


//  public void addGood(Good Good){
//    Good.setBoard(this);
//    this.goodList.add(Good);
//  }

  @Builder
  //Controller PostMapping 연결
  //dto에서 가져온 거 Controller로 보냄
  public Board(BoardRequestDto requestDto) {
    this._id = requestDto.get_id();
    this.img = requestDto.getImg();
    this.content = requestDto.getContent();
    this.layout = requestDto.getLayout();
  }

  //수정
  public void update(BoardRequestDto requestDto) {
    // 다시 지우니까 됨.....개..xthis._id = requestDto.get_id(); //ARC _id가 없어서 연결했을 때 오류있었음..
    this.img = requestDto.getImg();
    this.content = requestDto.getContent();
    this.layout = requestDto.getLayout();
  }


}
