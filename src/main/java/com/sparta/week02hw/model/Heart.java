package com.sparta.week02hw.model;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Heart extends Timestamped{ //AOP와 관계가 있는지..

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private Long id;

  private Long user_id;

  private Long board_ids;

  public Long id(Long id) {
    this.id = id;
    return id;
  }

}
