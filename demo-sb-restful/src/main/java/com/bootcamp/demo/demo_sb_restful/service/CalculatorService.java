package com.bootcamp.demo.demo_sb_restful.service;

import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_restful.exception.BusinessException;
import com.bootcamp.demo.demo_sb_restful.model.Operation;

@Service
public class CalculatorService {
  public Integer operate (Operation operation, Integer x, Integer y) {
    return switch (operation) {
      case SUM -> sum(x,y);
      case SUBTRACT -> sum(x,y);
      case MULTIPLY -> sum(x,y);
      case DIVIDE -> sum(x,y);
    };
  }
  
  public Integer sum(Integer x, Integer y) {
    return x + y;
  }

  public Integer subtract(Integer x, Integer y) {
    return x - y;
  }

  public Integer mulitply(Integer x, Integer y) {
    return x * y;
  }

  public Integer divide(Integer x, Integer y) {
    if (y == 0)
      throw new BusinessException
      ("CalculatorService.divide() / zero." + "x=" + x + ",y" + y);
    return x / y;
  }
}

