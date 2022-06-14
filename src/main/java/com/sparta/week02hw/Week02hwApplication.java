package com.sparta.week02hw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Week02hwApplication {

  public static void main(String[] args) {
    SpringApplication.run(Week02hwApplication.class, args);
  }
}
