package com.bootcamp.demo.demo_sb_customer.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_customer.controller.OrderOperation;
import com.bootcamp.demo.demo_sb_customer.entity.OrderEntity;
import com.bootcamp.demo.demo_sb_customer.service.OrderService;

@RestController
public class OrderController implements OrderOperation {
  @Autowired
  private OrderService orderService;

  @Override
   public List<OrderEntity> getOrders() {
    return this.orderService.getOrders();
   }

   @Override
    public OrderEntity createOrders(Long customerId, OrderEntity orderEntity) {
      return this.orderService.createOrder(customerId, orderEntity);
    }
}
