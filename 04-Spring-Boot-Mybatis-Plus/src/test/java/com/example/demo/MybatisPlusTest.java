//package com.example.demo;
//
//import com.example.demo.entity.User;
//import com.example.demo.mapper.UserMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@SpringBootTest
//public class MybatisPlusTest {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Test
//    void contextLoads() {
//        System.out.println(("----- selectAll method test 测试查询所有用户方法 ------"));
//        //selectList 的参数wrapper 是条件构造器，可以先写null
//        List<User> userList = userMapper.selectList(null);
//        //forEach 的参数是 Consumer类型的 语法糖
//        userList.forEach(System.out::println);
//    }
//
//}
