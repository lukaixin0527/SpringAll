package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @GetMapping("/test9081/{string}")
    public String getConfigInfo9081(@PathVariable(value = "string") String string) {

        return "Client-02-9081 ............................................................................................................. " + string;
    }
}
