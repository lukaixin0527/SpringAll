package com.example.demo.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "orderQueryService")
public interface OrderQueryService {

    @GetMapping("/order/query")
    public String orderQuery();

}
