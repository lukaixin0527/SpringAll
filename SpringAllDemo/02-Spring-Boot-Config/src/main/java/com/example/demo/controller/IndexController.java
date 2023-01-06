package com.example.demo.controller;

import com.example.demo.bean.BlogProperties;
import com.example.demo.bean.ConfigBean;
import com.example.demo.bean.TestConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class IndexController {
    @Autowired
    private BlogProperties blogProperties;
    @Autowired
    private ConfigBean configBean;
    @Autowired
    private TestConfigBean testConfigBean;

    @RequestMapping("/")
    String index() {
        return testConfigBean.getName()+"，"+testConfigBean.getAge();
    }
}
