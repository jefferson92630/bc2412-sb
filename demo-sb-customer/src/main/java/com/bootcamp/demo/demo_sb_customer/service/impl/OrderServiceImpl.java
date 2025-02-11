package com.bootcamp.demo.demo_sb_customer.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_customer.Exception.BusinessException;
import com.bootcamp.demo.demo_sb_customer.entity.CustomerEntity;
import com.bootcamp.demo.demo_sb_customer.entity.OrderEntity;
import com.bootcamp.demo.demo_sb_customer.repository.CustomerRepository;
import com.bootcamp.demo.demo_sb_customer.repository.OrderRepository;
import com.bootcamp.demo.demo_sb_customer.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private OrderRepository orderRepository;
  
  // if customer id not found, throw new BusinessException("Customer ID not found.")
  @Override
  public OrderEntity createOrder(Long customerId, OrderEntity orderEntity) {
    CustomerEntity customerEntity = this.customerRepository.findById(customerId)
      .orElseThrow(() -> new BusinessException("Customer ID Not Found"));
    orderEntity.setCustomerEntity(customerEntity);
    // Save orderEntity to DB
    return this.orderRepository.save(orderEntity);
    }
  
  @Override
  public List<OrderEntity> getOrders() {
    return this.orderRepository.findAll();
  }
}
