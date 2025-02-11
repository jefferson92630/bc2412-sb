package com.bootcamp.demo.demo_sb_customer.service;

import java.util.List;
import com.bootcamp.demo.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.demo.demo_sb_customer.model.Customer;

public interface CustomerService {
  List<CustomerEntity> getCustomers();
  CustomerEntity createCustomer(CustomerEntity customerEntity);
}