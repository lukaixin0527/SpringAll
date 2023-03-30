package com.example.demo.controller;

import com.example.demo.service.OrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class Controller {

    @Resource
    private OrderQueryService orderQueryService;

    @GetMapping("/order/shoppingCart")
    public String orderQuery() {
        return orderQueryService.orderQuery() + "加入购物车成功..." + System.currentTimeMillis();
    }

}
