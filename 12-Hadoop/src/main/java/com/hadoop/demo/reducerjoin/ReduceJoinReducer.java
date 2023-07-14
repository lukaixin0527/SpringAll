package com.hadoop.demo.reducerjoin;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReduceJoinReducer extends Reducer<Text, OrderInfo, Text, OrderInfo> {

    private Logger logger = Logger.getLogger(ReduceJoinReducer.class);

    @Override
    protected void reduce(Text key, Iterable<OrderInfo> values, Reducer<Text, OrderInfo, Text, OrderInfo>.Context context) throws IOException, InterruptedException {

        logger.info("=====================================");
        logger.info("key: " + key);

        List<OrderInfo> orderInfoList = new ArrayList<>();
        String pname = "";

        Iterator<OrderInfo> iterator = values.iterator();
        while (iterator.hasNext()) {
            OrderInfo orderInfo = iterator.next();
            logger.info(orderInfo);
            if("_PRODUCT_".equals(orderInfo.get_from_table())) {
                pname = orderInfo.getPname();
            } else {

                // 此处不能直接使用：orderInfoList.add(orderInfo);
                // Hadoop迭代器为了优化效率，使用了对象重用。
                // 迭代时value始终指向同一个内存地址，改变的只是引用地址中的字段属性
                // 即这个循环了这么多次的orderInfo，其实是同一个对象，只是对象的属性值在不断变化
                // 所以这里需要 new 一个新对象来存放这些属性，然后将这个新对象塞给集合

                OrderInfo orderInfoTemp = new OrderInfo();
//        orderInfoTemp.setId(orderInfo.getId());
//        orderInfoTemp.setPid(orderInfo.getPid());
//        orderInfoTemp.setAmount(orderInfo.getAmount());
//        orderInfoTemp.set_from_table(orderInfo.get_from_table());
                try {
                    // 使用BeanUtils工具对同名属性进行赋值
                    // 第一个参数：要设置值的目标对象
                    // 第二个参数：源对象
                    BeanUtils.copyProperties(orderInfoTemp, orderInfo);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                orderInfoList.add(orderInfoTemp);
            }
        }

        logger.info("**********************************");
        for (OrderInfo orderInfo : orderInfoList) {
            orderInfo.setPname(pname);
            context.write(key, orderInfo);
            logger.info(orderInfo);
        }
        logger.info("===========================================");
    }
}
