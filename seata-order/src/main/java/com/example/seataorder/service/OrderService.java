package com.example.seataorder.service;


import com.example.seataorder.entry.Order;

/**
 * @author i
 */
public interface OrderService {
    /**
     * 创建订单
     * @param order
     */
    void createOrder(Order order);
}

