package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "consumer")
public interface ConsumerService {

    @GetMapping(value = "/test/{string}")
    public String getConfigInfo(@PathVariable(value = "string") String string);
}
