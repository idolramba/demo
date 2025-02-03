package com.example.demo.controller;

import com.example.demo.dto.Order;
import com.example.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/orders")
    public String createOrder(@RequestBody Order order) {
        log.info("order = {}", order);
        orderService.saveOrder(order);
        return "Order has been successfully created with ID: " + order.getOrderId();
    }

    @GetMapping("/order")
    public String createOrder() {
        return "order";
    }
}