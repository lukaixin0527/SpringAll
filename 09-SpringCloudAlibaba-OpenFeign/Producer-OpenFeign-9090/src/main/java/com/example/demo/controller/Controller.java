package com.example.demo.controller;

import com.example.demo.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
public class Controller {

    @Resource
    private ConsumerService consumerService;

    @GetMapping("/server")
    public String getConfigInfo1() {
        return consumerService.getConfigInfo("OpenFeign测试");
    }
}
