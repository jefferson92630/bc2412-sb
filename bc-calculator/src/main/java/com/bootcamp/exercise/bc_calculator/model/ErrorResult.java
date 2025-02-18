package com.bootcamp.exercise.bc_calculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResult {
  private int code;
  private String message;
 }

