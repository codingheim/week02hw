package com.sparta.week02hw.repository;

import com.sparta.week02hw.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long> {
  boolean findByEmailAndPassword(String email, String pwd);
}
