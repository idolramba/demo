package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Order {
    private Long orderId;
    private String orderNumber;
    private String orderDate;
    private List<OrderDetail> orderDetails;;
}
