package com.sparta.week02hw.repository;


import com.sparta.week02hw.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BoardRepository extends JpaRepository<Board,Long> {
  List<Board> findAllByOrderByModifiedAtDesc();
}
