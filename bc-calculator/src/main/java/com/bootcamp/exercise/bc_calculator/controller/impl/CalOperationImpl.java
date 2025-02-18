package com.bootcamp.exercise.bc_calculator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.exercise.bc_calculator.controller.CalOperation;
import com.bootcamp.exercise.bc_calculator.model.Calculator;
import com.bootcamp.exercise.bc_calculator.service.CalService;

@RestController
public class CalOperationImpl implements CalOperation {
  @Autowired
  public CalService calService;

@Override
  public Calculator calculate(String x, String y, String operation) {
   return this.calService.calculate(x, y, operation);
  }

@Override
  public Calculator createCal(String operation, String x, String y) {
    return this.calService.createCal(x, y, operation);
 }

}
