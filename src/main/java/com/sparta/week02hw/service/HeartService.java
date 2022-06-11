package com.sparta.week02hw.service;


import com.sparta.week02hw.dto.HeartRequestDto;
import com.sparta.week02hw.model.Heart;
import com.sparta.week02hw.repository.HeartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor //DI/IoC 사용될 때 쓰임.
@Service
public class HeartService {

  private final HeartRepository heartRepository;
  private final UserService userService;

  public static void heart(HeartRequestDto requestDto) {

  }
  //create
  public Heart heartAction(Heart heart) {
    return heartRepository.save(heart);
  }

  //delete
  public void heartCancel(Long id) {
    heartRepository.deleteById(id);
  }

}
