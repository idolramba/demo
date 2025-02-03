package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetail {
    private Long id;
    private Long orderId;
    private String productName;
    private int quantity;
    private double price;

}
