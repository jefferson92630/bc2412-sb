package com.example.demo.demo_sb_goodbye.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodbyeController {
  
  @GetMapping(value = "/ipad/goodbye")
  public String goodBye() {
    return "Goodbye!";
  }
}
