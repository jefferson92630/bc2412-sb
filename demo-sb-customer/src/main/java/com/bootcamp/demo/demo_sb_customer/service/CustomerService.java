package com.bootcamp.demo.demo_sb_customer.service;

import java.util.List;
import com.bootcamp.demo.demo_sb_customer.entity.CustomerEntity;

public interface CustomerService {
  List<CustomerEntity> getCustomers();
  CustomerEntity createCustomer(CustomerEntity customerEntity);

  List<CustomerEntity> getCustomersByJPQL(String customerName);
  List<CustomerEntity> getCustomersByNQ(String customerName);
}
