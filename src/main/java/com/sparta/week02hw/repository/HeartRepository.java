package com.sparta.week02hw.repository;

import com.sparta.week02hw.model.Heart;
import com.sparta.week02hw.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeartRepository extends JpaRepository<Heart,Long> {
  Optional<Heart> findHeartByUserAndBoardid(User user, Long boardid);
}
