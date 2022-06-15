package com.sparta.week02hw.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.week02hw.dto.UserRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
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

  @ElementCollection(fetch = FetchType.EAGER)
  @Builder.Default
  private List<String> roles = new ArrayList<>();

  @JsonIgnore
  @OneToMany(mappedBy = "writerId", cascade = CascadeType.ALL)
  private List<Board> boards;

  public User(UserRequestDto requestDto) {

    this.name = requestDto.getName();
    this.nickname = requestDto.getNickname();
    this.email = requestDto.getEmail();
    this.password = requestDto.getPassword();

  }

  @Builder
  public User(String name, String password, List<String> roles, String email, String nickname) {
    this.name = name;
    this.password = password;
    this.roles = roles;
    this.email = email;
    this.nickname = nickname;
  }

}
