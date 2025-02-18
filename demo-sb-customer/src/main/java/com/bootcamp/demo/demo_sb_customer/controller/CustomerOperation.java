package com.bootcamp.demo.demo_sb_customer.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.demo.demo_sb_customer.codewave.ApiResp;
import com.bootcamp.demo.demo_sb_customer.entity.CustomerEntity;

public interface CustomerOperation {
  @GetMapping(value = "/customers")
  @ResponseStatus(HttpStatus.OK) // 200
  ApiResp<List<CustomerEntity>> getCustomers();

  @PostMapping(value = "/customer")
  @ResponseStatus(HttpStatus.CREATED) // 201
  ApiResp<CustomerEntity> createCustomer(@RequestBody CustomerEntity customerEntity);
}
