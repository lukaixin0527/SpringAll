package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @GetMapping("/test/{string}")
    public String getConfigInfo(@PathVariable(value = "string") String string) {
        return "Client-02-9081 " + string;
    }
}
