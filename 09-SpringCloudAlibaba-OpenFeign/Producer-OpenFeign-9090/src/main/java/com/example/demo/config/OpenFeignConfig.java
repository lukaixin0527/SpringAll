package com.example.demo.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class    OpenFeignConfig {
    @Bean
    Logger.Level feignLoggerLever() {
        return Logger.Level.FULL;
    }
}
