package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "consumer9080")
public interface ConsumerService9080 {

    @GetMapping(value = "/test9080/{string}")
    public String getConfigInfo9080(@PathVariable(value = "string") String string);
}
