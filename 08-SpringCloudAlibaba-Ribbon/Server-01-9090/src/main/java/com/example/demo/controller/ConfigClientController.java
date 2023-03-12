package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
public class ConfigClientController {

    @Autowired
    private RestTemplate restTemplate;

    // 客户端注册到Nacos的服务名称
    private static final String client_name = "client";

    @GetMapping("/server")
    public String getConfigInfo1() {
        return restTemplate.getForObject("http://" + client_name + "/ribbon", String.class);
    }
}
