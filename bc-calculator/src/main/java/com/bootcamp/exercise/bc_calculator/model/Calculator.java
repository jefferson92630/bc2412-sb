package com.bootcamp.exercise.bc_calculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Calculator {
  private String x;
  private String y;
  private String operation;
  private String result;

  public Calculator (String x, String y, String operation) {
    this.x = x;
    this.y = y;
    this.operation = operation;
  }
}
