package com.sparta.week02hw.repository;

import com.sparta.week02hw.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
}
