package com.example.demo.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @projectName: SpringAll
 * @package: com.example.demo.config
 * @className: DefaultRequestOriginParser
 * @author: 路凯新
 * @description: TODO
 * @date: 2023/3/27 18:11
 * @version: 1.0
 */
@Component
public class DefaultRequestOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {
        //基于请求参数
        String origin = request.getParameter("origin");
        //基于请求头
        //String origin = request.getHeader("origin");
        //基于请求rui
        //String origin = request.getRequestURI();
        //基于...
        return origin;
    }
}