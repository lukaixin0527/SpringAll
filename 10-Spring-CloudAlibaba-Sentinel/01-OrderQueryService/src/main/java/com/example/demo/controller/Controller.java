package com.example.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.demo.handler.LimitHandler;
import com.example.demo.service.OrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private OrderQueryService orderQueryService;


    @GetMapping("/order/query")
    public String orderQuery() throws InterruptedException {
        Thread.sleep(2000);
        return "订单查询成功！";
    }

    /**
     * 使用@SentinelResource标签开启热点参数限流功能
     *
     * @SentinelResource(value)对应Sentinel控制台-热点规则-资源名
     * @SentinelResource(blockHandeler)指定热点限流生效后的处理函数
     */
    @GetMapping("/order/queryParam")
    @SentinelResource(value = "/order/queryParam", blockHandler = "deal_testHotKey")
    public String orderQueryParam(@RequestParam(value = "orderId", required = false) String orderId,
                                  @RequestParam(value = "userName", required = false) String userName) {
        System.out.println("请求参数orderId：" + orderId + "userName:" + userName);
        return "订单查询成功！";
    }

    public String deal_testHotKey(String orderId, String userName, BlockException exception) {
        // sentinel默认的提示为:Blocked by Sentinel(flow limiting),这里可以自定义修改
        return "-------------------- 自定义返回内容 --------------------------";
    }


    @GetMapping("/limit")
    @SentinelResource(value = "/limit", blockHandler = "limitBlockHandler")
    public String limit(String connect) {
        return "订单查询成功！" + connect;
    }

    public String limitBlockHandler(String connect, BlockException exception) {
        // sentinel默认的提示为:Blocked by Sentinel(flow limiting),这里可以自定义修改
        return "-------------------- 服务发生降级 --------------------------";
    }

    @GetMapping("/limit1")
    @SentinelResource(value = "/limit1", blockHandlerClass = LimitHandler.class, blockHandler = "handlerException")
    public String limit1(String connect) {
        return "订单查询成功！" + connect;
    }


    @GetMapping("/errorIndex")
    @SentinelResource(value = "/errorIndex", fallback = "errorBlockHandler")
    public String error(String connect) {
        int a = 1 / 0;
        return "订单查询成功！" + connect;
    }

    public String errorBlockHandler(String connect) {
        return "-------------------- 服务发生异常 --------------------------";
    }


    /**
     * 订单支付
     *
     * @return
     */
    @GetMapping("/order/pay")
    public String orderPay(@RequestParam(value = "origin", required = false) String origin) {
        return orderQueryService.orderQuery();
    }

    /**
     * 添加购物车
     *
     * @return
     */
    @GetMapping("/order/shoppingCart")
    public String orderShoppingCart() {
        return orderQueryService.orderQuery();
    }
}
