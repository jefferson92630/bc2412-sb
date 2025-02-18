package com.bootcamp.exercise.bc_calculator.service;

import com.bootcamp.exercise.bc_calculator.model.Calculator;

public interface CalService {
  Calculator calculate (String x, String y, String operation);
  Calculator createCal (String x, String y, String operation);
}