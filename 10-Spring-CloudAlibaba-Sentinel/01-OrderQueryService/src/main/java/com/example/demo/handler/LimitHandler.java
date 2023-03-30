package com.example.demo.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @projectName: SpringAll
 * @package: com.example.demo.handler
 * @className: LimitHandler
 * @author: 路凯新
 * @description: TODO
 * @date: 2023/3/30 15:32
 * @version: 1.0
 */
public class LimitHandler {

    public static String handlerException(String connect,BlockException blockException) {
        return "服务降级。。。。。";
    }
}
