package com.example.seataorder.mapper;


import com.example.seataorder.entry.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhubayi
 */
@Mapper
public interface OrderDao {
    /**
     * 创建订单
     * @param order
     */
    void createOrder(Order order);

    /**
     * 更新订单
     * @param userId
     * @param status
     */
    void updateStatus(@Param("userId") Long userId, @Param("status") Integer status);
}

