package com.example.demo.config;

import com.example.demo.service.MyWebService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {
    @Autowired
    private MyWebService myWebService;

    @Autowired
    private Bus bus;

    /**
     * 发布服务
     * @return
     */
    @Bean
    public Endpoint userServiceEndpoint() {
        System.out.println("服务发布。。。");
        //这里指定的端口不能跟应用的端口冲突, 单独指定
        String path = "http://127.0.0.1:9090/user";
        EndpointImpl userEndpoint = new EndpointImpl(bus, myWebService);
        userEndpoint.publish(path);
        System.out.println("服务发布成功，path:" + path);
        System.out.println(String.format("在线的wsdl：%s?wsdl", path));
        return userEndpoint;
    }
}
