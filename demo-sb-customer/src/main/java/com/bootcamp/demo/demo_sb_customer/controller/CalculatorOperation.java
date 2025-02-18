package com.bootcamp.demo.demo_sb_customer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface CalculatorOperation {
  
  @GetMapping(value = "/calculate/{x}/{y}")
  public int calculate(@PathVariable int x, @PathVariable int y);

  }
