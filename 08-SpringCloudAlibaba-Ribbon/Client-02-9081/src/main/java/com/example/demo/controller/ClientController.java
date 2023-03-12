package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientController {
    @GetMapping("/ribbon")
    public String getConfigInfo() {
        return "Client-02-9081";
    }
}
