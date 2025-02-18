package com.bootcamp.demo.demo_sb_customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.bootcamp.demo.demo_sb_customer.service.CalculatorService;

@SpringBootTest
public class CalculatorServiceTest {
  @Autowired
  private CalculatorService calculatorService;

  
  @Test
  void testSum() {
    assertEquals(3, calculatorService.sum(1,2));
  }

  @Test
  void testSubstract() {
    assertEquals(-1, calculatorService.subtract(1, 2));
  }
}
