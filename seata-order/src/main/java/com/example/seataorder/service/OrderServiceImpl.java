package com.example.seataorder.service;

import com.example.seataorder.entry.Order;
import com.example.seataorder.feign.AccountService;
import com.example.seataorder.feign.StorageService;
import com.example.seataorder.mapper.OrderDao;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 *  i
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;
    /**
     * 创建订单
     *
     * @param order
     */
    @Override
    @GlobalTransactional
    public void createOrder(Order order) {
        log.info("=====>{}","开始新建订单");
        orderDao.createOrder(order);
        log.info("=====>{}","新建订单成功");

        log.info("=====>{}","库存减少");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("=====>{}","库存减少成功");

        log.info("=====>{}","开始减少余额");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("=====>{}","减少余额成功");

        log.info("=====>{}","开始修改订单状态");
        orderDao.updateStatus(order.getUserId(),0);
        log.info("=====>{}","修改订单状态成功");

        // 故意制造异常  测试分布式事务
//        int  number = 1/0;
        log.info("=====>{}","end");
    }
}

