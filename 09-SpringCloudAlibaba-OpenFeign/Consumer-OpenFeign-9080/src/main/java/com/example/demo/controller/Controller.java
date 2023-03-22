package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
public class Controller {

    @GetMapping("/test9080/{string}")
    public String getConfigInfo9080(@PathVariable(value = "string") String string) throws Exception {
       TimeUnit.SECONDS.sleep(6);
        return "Client-02-9080 ............................................................................................................. " + string;
    }
}
