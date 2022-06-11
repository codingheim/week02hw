package com.sparta.week02hw.service;


import com.sparta.week02hw.model.Heart;
import com.sparta.week02hw.repository.HeartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HeartService {

  private final HeartRepository heartRepository;

  //create
  public Heart heartAction(Heart heart) {
    return heartRepository.save(heart);
  }

}
