package com.bootcamp.demo.demo_sb_customer.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_customer.controller.CustomerOperation;
import com.bootcamp.demo.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.demo.demo_sb_customer.model.Customer;
import com.bootcamp.demo.demo_sb_customer.service.CustomerService;

@RestController
public class CustomerController implements CustomerOperation {
  @Autowired
  private CustomerService customerService;

  @Override
  public List<CustomerEntity> getCustomers() {
    return this.customerService.getCustomers();
  }
 @Override
  public CustomerEntity createCustomer(CustomerEntity customerEntity) {
    return this.customerService.createCustomer(customerEntity);
  }
}