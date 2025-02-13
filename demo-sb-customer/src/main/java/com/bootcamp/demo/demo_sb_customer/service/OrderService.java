package com.bootcamp.demo.demo_sb_customer.service;

import java.util.List;
import com.bootcamp.demo.demo_sb_customer.entity.OrderEntity;

public interface OrderService {
  List<OrderEntity> getOrders();
  OrderEntity createOrder(Long customerId, OrderEntity orderEntity);
}