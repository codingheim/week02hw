package com.sparta.week02hw.model;


import antlr.collections.List;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Good extends Timestamped {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  private Board board;


  public Good(User user, Board board){
    user.addGood(this);
    board.addGood(this);
  }

  public Good() {

  }

}
