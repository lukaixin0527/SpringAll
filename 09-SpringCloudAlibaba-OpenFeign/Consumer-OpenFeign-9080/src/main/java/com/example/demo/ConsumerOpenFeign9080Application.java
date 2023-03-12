package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerOpenFeign9080Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOpenFeign9080Application.class, args);
    }
}
