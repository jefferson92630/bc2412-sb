package com.bootcamp.exercise.bc_calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.exercise.bc_calculator.model.Calculator;

public interface CalOperation {
  @GetMapping (value = "/operation/{operation}/{x}/{y}")
  Calculator calculate(@PathVariable String operation, @PathVariable String x, @PathVariable String y);

  @GetMapping (value = "/operation/")
  Calculator calculate2(@RequestParam String operation, @RequestParam String x, @RequestParam String y);

  @PostMapping(value = "/operation/{operation}/{x}/{y}")
  Calculator createCal(@PathVariable String operation, @PathVariable String x, @PathVariable String y);
}
