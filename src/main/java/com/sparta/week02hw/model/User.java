package com.sparta.week02hw.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  @Column(name = "USER_ID")
  private Long id;

  @OneToMany(mappedBy = "user")
  @JoinColumn(name = "USER_ID")
  private Board boardid;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String nickname;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String email;

  //Service
  public User(String name,String nickname,String password, String email) {
    this.name = name;
    this.nickname = nickname;
    this.password = password;
    this.email = email;
  }
}
