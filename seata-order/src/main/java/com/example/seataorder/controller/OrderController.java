package com.example.seataorder.controller;


import com.example.seataorder.common.CommonResult;
import com.example.seataorder.entry.Order;
import com.example.seataorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  i
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("create")
    public CommonResult create(@RequestBody Order order){
        orderService.createOrder(order);
        return new CommonResult(200,"创建成功");
    }
}

