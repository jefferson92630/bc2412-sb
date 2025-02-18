package com.bootcamp.exercise.bc_calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.bootcamp.exercise.bc_calculator.model.Calculator;

public interface CalOperation {
  @GetMapping (value = "/operation/{operation}/{x}/{y}")
  public Calculator calculate(@PathVariable String operation, @PathVariable String x, @PathVariable String y);

  @PostMapping(value = "/operation/{operation}/{x}/{y}")
  public Calculator createCal(@PathVariable String operation, @PathVariable String x, @PathVariable String y);
}
