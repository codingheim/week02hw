package com.sparta.week02hw.controller;


import com.sparta.week02hw.security.UserDetailsImpl;
import com.sparta.week02hw.service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class GoodController {

  private final GoodService goodService;



//  @GetMapping("/api/board/{boardId}/like")
//  public String findGood(@PathVariable Long boardId, @AuthenticationPrincipal UserDetailsImpl userDetails){
//    CheckedController.userchecker(userDetails);
//    return goodService.findGood(boardId,userDetails);
//  }

}
