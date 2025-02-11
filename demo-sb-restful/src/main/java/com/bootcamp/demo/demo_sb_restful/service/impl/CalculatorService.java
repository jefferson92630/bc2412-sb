package com.bootcamp.demo.demo_sb_restful.service.impl;

import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_restful.exception.BusinessException;
import com.bootcamp.demo.demo_sb_restful.model.Operation;

@Service
public class CalculatorService {
  public Integer operate (Operation operation, Integer x, Integer y) {
    return switch (operation) {
      case SUM -> sum(x,y);
      case SUBTRACT -> subtract(x,y);
      case MULTIPLY -> multiply(x,y);
      case DIVIDE -> divide(x,y);
    };
  }
  
  private Integer sum(Integer x, Integer y) {
    return x + y;
  }

  private Integer subtract(Integer x, Integer y) {
    return x - y;
  }

  private Integer multiply(Integer x, Integer y) {
    return x * y;
  }

  private Integer divide(Integer x, Integer y) {
    if (y == 0)
      throw new BusinessException
      ("CalculatorService.divide() / zero." + "x=" + x + ",y" + y);
    return x / y;
  }
}

