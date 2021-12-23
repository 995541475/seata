package com.example.seataorder.service;


import com.example.seataorder.entry.Order;

/**
 * @author zhubayi
 */
public interface OrderService {
    /**
     * 创建订单
     * @param order
     */
    void createOrder(Order order);
}

