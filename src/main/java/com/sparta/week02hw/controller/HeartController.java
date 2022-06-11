package com.sparta.week02hw.controller;

import com.sparta.week02hw.dto.HeartRequestDto;
import com.sparta.week02hw.model.Heart;
import com.sparta.week02hw.repository.HeartRepository;
import com.sparta.week02hw.service.HeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HeartController {

  private final HeartService heartService;

  @PostMapping("/api/hearts")
  public Long heartAction(@RequestBody HeartRequestDto requestDto) {
    HeartService.heart(requestDto);
    return heartAction(requestDto);
  }

  @DeleteMapping("/api/hearts")
  public Heart heartCancle(@RequestBody HeartRequestDto requestDto) {
    HeartService.heart(requestDto);
    return heartCancle(requestDto);
  }
}
