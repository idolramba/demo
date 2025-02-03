package com.example.demo.service;

import com.example.demo.mapper.OrderMapper;
import com.example.demo.dto.Order;
import com.example.demo.dto.OrderDetail;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Transactional
    public void saveOrder(Order order) {

        order.setOrderId( orderMapper.getNextId() );

        // 주문 저장
        orderMapper.insertOrder(order);

        // 주문 아이디가 설정되었는지 확인하고, 주문 상세 저장
        if (order.getOrderId() != null) {
            for (OrderDetail orderDetail : order.getOrderDetails()) {
                orderDetail.setOrderId(order.getOrderId());
            }

            // 여러 개의 주문 상세 데이터를 한 번에 저장 (List<OrderDetail>을 전달)
            orderMapper.insertOrderItems(order.getOrderDetails(), order.getOrderId());
        }
    }
}
