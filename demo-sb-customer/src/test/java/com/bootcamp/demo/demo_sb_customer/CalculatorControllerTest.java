package com.bootcamp.demo.demo_sb_customer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester.MockMvcRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.bootcamp.demo.demo_sb_customer.controller.impl.CalculatorController;
import com.bootcamp.demo.demo_sb_customer.service.CalculatorService;

@WebMvcTest(controllers = CalculatorController.class)
public class CalculatorControllerTest {
  
  @MockBean
  private CalculatorService calculatorService;

  @Autowired
  private MockMvc mockMvc;

  @Test
  void calculateTest() {
    Mockito.when(calculatorService.sum(1,2)).thenReturn(100);
    Mockito.when(calculatorService.subtract(1, 2)).thenReturn(200);

    // test
    mockMvc.perform(MockMvcRequestBuilders.get("/calculate")).param("x", "1")

  }
}
