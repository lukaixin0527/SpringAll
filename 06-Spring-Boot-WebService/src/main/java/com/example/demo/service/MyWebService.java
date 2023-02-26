package com.example.demo.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "MyWebServiceTest", targetNamespace = "http://service.demo.example.com")
public interface MyWebService {

    @WebMethod
    public String show(String name);

    @WebMethod
    public String showTwo(String name, Integer age);
}
