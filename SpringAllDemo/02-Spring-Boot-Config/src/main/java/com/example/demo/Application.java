package com.example.demo;

import com.example.demo.bean.ConfigBean;
import com.example.demo.bean.TestConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;



@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class, TestConfigBean.class})
//@ImportResource({"classpath:some-application.xml"})
public class Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setAddCommandLineProperties(false);
        app.run(args);
    }
}