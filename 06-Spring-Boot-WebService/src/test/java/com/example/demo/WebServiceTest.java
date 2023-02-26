package com.example.demo;


import com.example.demo.client.MyWebServiceImplService;

public class WebServiceTest {

    public static void main(String[] args) {
        MyWebServiceImplService service = new MyWebServiceImplService();
        String name = service.getMyWebServiceTestPort().show("reindeer");
        System.out.println("！！！！！！！！" + name);

        String name1 = service.getMyWebServiceTestPort().showTwo("reindeer", 1111);
        System.out.println(">>>>>" + name1);
    }
}
