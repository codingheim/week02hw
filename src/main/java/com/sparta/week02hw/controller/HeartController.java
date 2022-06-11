package com.sparta.week02hw.controller;

import com.sparta.week02hw.service.HeartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HeartController {

  private final HeartService heartService;

  
}
