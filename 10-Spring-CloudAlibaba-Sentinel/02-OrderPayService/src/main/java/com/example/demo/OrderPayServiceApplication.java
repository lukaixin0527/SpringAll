package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@EnableDiscoveryClient // 通过注解 开启nacos服务注册
@EnableFeignClients // 整合openFeign
public class OrderPayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderPayServiceApplication.class, args);
    }
}
