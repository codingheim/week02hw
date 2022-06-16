package com.sparta.week02hw.repository;

import com.sparta.week02hw.model.Board;
import com.sparta.week02hw.model.Good;
import com.sparta.week02hw.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GoodRepository extends JpaRepository<Good,Long> {
  Optional<Good> findByBoardAndUser(Board board, User user);
}
