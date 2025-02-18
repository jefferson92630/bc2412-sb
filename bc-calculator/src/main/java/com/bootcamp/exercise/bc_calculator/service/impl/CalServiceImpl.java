package com.bootcamp.exercise.bc_calculator.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;

import com.bootcamp.exercise.bc_calculator.exception.BusinessException;
import com.bootcamp.exercise.bc_calculator.model.Calculator;
import com.bootcamp.exercise.bc_calculator.service.CalService;

@Service
public class CalServiceImpl implements CalService {

  public Calculator createCal (String x, String y, String operation) {
    return new Calculator(x, y, operation);
  }

  @Override
  public Calculator calculate(String x, String y, String operation) {
    Double result = operate(x, y, operation);
    Calculator calculator = createCal(x, y, operation);
    calculator.setResult(result.toString());
    return calculator;
  }

  private Double operate (String x, String y, String operation) {
    try {
      return switch (operation) {
        case "add" -> sum(x, y);
        case "sub" -> subtract(x, y);
        case "mul" -> multiply(x, y);
        case "div" -> divide(x, y);
        default -> throw new BusinessException("Invalid operation: " + operation);
      };
    } catch (NumberFormatException e) {
      throw new BusinessException("Invalid input for x or y. x=" + x + ", y=" + y);
    }
  }
  
  private Double sum(String x, String y) {
    return BigDecimal.valueOf(Double.parseDouble(x))
    .add(BigDecimal.valueOf(Double.parseDouble(y)))
    .doubleValue();
  }

  private Double subtract(String x, String y) {
    return BigDecimal.valueOf(Double.parseDouble(x))
    .subtract(BigDecimal.valueOf(Double.parseDouble(y)))
    .doubleValue();
  }

  private Double multiply(String x, String y) {
     return BigDecimal.valueOf(Double.parseDouble(x))
    .multiply(BigDecimal.valueOf(Double.parseDouble(y)))
    .doubleValue();
  }

  private Double divide(String x, String y) {
    if (Double.parseDouble(y) == 0) {
      throw new BusinessException
      ("CalService.divide() / zero." + "x=" + x + ",y" + y);
    }
    return BigDecimal.valueOf(Double.parseDouble(x))
    .divide(BigDecimal.valueOf(Double.parseDouble(y)), 5, RoundingMode.UP)
    .doubleValue();
  }
}

