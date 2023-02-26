package com.example.demo.service.impl;

import com.example.demo.service.MyWebService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service
@WebService(name = "MyWebServiceTest", targetNamespace = "http://service.demo.example.com",
        endpointInterface = "com.example.demo.service.MyWebService")
public class MyWebServiceImpl implements MyWebService {

    @Override
    public String show(String name) {
        return name + "Web-Service Hello !";
    }

    @Override
    public String showTwo(String name, Integer age) {
        return name + age + "Web-Service Hello !";
    }
}
