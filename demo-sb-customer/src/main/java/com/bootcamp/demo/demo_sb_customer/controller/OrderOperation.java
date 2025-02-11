package com.bootcamp.demo.demo_sb_customer.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_sb_customer.entity.OrderEntity;

public interface OrderOperation {
  @GetMapping(value = "/orders")
  List<OrderEntity> getOrders();

// http://localhost:8100/order?cid=1
  @PostMapping(value = "/order")
  OrderEntity createOrders(@RequestParam(value = "cid") Long customerId,
    @RequestBody OrderEntity orderEntity);
  
}
