package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "consumer9081")
public interface ConsumerService9081 {

    @GetMapping(value = "/test9081/{string}")
    public String getConfigInfo9081(@PathVariable(value = "string") String string);
}
