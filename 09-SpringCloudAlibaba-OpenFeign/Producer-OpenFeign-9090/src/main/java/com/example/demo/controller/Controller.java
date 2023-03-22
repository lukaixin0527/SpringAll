package com.example.demo.controller;

import com.example.demo.service.ConsumerService9080;
import com.example.demo.service.ConsumerService9081;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class Controller {
    @Resource
    private ConsumerService9080 consumerService9080;
    @Resource
    private ConsumerService9081 consumerService9081;
    /**
     * 测试接口
     */
    @GetMapping("/server")
    public String getConfigInfo1() {
        System.out.println(consumerService9080.getConfigInfo9080("OpenFeign测试"));
        System.out.println(consumerService9081.getConfigInfo9081("OpenFeign测试"));
        return "success.............................................................................................................";
    }
}
