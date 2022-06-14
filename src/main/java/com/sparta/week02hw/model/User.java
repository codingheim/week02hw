package com.sparta.week02hw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.week02hw.dto.BoardRequestDto;
import com.sparta.week02hw.dto.UserRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "USER")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class User extends Timestamped {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long _id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String nickname;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String password;

  @JsonIgnore
  @OneToMany(mappedBy = "writer_id", cascade = CascadeType.ALL)
  private List<Board> boards;



  public User(UserRequestDto requestDto) {
    this.name = requestDto.getName();
    this.email = requestDto.getEmail();
    this.nickname = requestDto.getNickname();
    this.password = requestDto.getPassword();
  }

  

  public void update(UserRequestDto requestDto) {
    this.name = requestDto.getName();
    this.email = requestDto.getEmail();
    this.nickname = requestDto.getNickname();
    this.password = requestDto.getPassword();
  }


  public void createBoards(Board board) {
    board.setWriterId(this);

  }
}
