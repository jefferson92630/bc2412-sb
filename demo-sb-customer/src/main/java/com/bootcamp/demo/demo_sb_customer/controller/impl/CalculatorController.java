package com.bootcamp.demo.demo_sb_customer.controller.impl;

import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_customer.controller.CalculatorOperation;


// @Autowired
// CalculatorOperation calculatorOperation;
// then method will call calculatorOperation.xxx()

@RestController
public class CalculatorController implements CalculatorOperation{
  // Unit test for calculate: assume sum() return 100 and subtract 200 -> -100
  @Override
  public int calculate(int x, int y) {
    return sum(x, y) - subtract (x, y);
  } 

  // Unit test for sum()
  // 1 + 2 -> 3
  private int sum(int x, int y) {
    return x + y;
  }

  // Unit test for subtract()
  // 1 - 2 -> -1
  private int subtract(int x, int y) {
    return x - y;
  }

}
