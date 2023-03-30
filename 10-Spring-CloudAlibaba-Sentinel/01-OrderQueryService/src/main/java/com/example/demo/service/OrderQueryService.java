package com.example.demo.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class OrderQueryService {

    @SentinelResource("orderQuery")
    public String orderQuery() {
        return "查询订单成功！" + System.currentTimeMillis();

    }
}
