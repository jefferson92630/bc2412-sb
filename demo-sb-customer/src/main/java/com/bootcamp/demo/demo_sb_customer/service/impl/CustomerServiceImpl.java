package com.bootcamp.demo.demo_sb_customer.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.demo.demo_sb_customer.model.Customer;
import com.bootcamp.demo.demo_sb_customer.repository.CustomerRepository;
import com.bootcamp.demo.demo_sb_customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public List<CustomerEntity> getCustomers() {
    return this.customerRepository.findAll();
  }

  public List<CustomerEntity> findName(String name) {
    return this.customerRepository.findByName(CustomerEntity.name);
  }

  @Override
  public CustomerEntity createCustomer(CustomerEntity customerEntity) {
    return customerRepository.save(customerEntity);
  }
}