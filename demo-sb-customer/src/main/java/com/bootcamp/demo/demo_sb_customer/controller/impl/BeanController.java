package com.bootcamp.demo.demo_sb_customer.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanController {
  @Autowired
  private String abc;

  @GetMapping(value = "/bean/tutor")
  public String getTutor() {
    return abc;
  }
}
