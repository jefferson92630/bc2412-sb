package com.bootcamp.demo.demo_sb_customer.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bootcamp.demo.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.demo.demo_sb_customer.model.Customer;

public interface CustomerOperation {
  @GetMapping(value = "/customers")
  List<CustomerEntity> getCustomers();

  @PostMapping(value = "/customer")
  CustomerEntity createCustomer(@RequestBody CustomerEntity customerEntity);
}
