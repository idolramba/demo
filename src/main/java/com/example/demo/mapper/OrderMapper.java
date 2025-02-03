package com.example.demo.mapper;

import com.example.demo.dto.Order;
import com.example.demo.dto.OrderDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    // 주문 저장
    void insertOrder(Order order);

    // 주문 상세 저장
    void insertOrderItems(@Param("orderDetails") List<OrderDetail> orderDetails, @Param("orderId") Long orderId);

    Long getNextId();
}