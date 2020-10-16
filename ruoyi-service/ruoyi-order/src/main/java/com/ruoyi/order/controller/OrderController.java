package com.ruoyi.order.controller;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.order.entity.Order;
import com.ruoyi.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public R create(Order order) {
        orderService.create(order);
        return R.ok("订单创建完成");
    }



}
