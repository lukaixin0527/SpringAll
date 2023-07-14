package com.hadoop.demo.reducerjoin;


import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.log4j.Logger;

import java.io.IOException;
public class ReduceJoinMapper extends Mapper<LongWritable, Text, Text, OrderInfo> {
    private Logger logger = Logger.getLogger(ReduceJoinMapper.class);

    private Text outKey = new Text();
    private String fileName = ""; // 当前MapTask处理的文件名称

    /**
     * 重写初始化方法，在初始化方法中通过切片信息获取到文件名称，避免每次都在map方法中读取耗费资源
     * 因为每个切片对应一个MapTask，所以这个MapTask的初始化方法就是这个切片的初始化方法
     * 因为一个文件可以切多个片，但是一个切片只会对应一个文件，所以这个切片对应的文件信息是固定的
     */
    @Override
    protected void setup(Mapper<LongWritable, Text, Text, OrderInfo>.Context context) throws IOException, InterruptedException {
        // JobSubmitter 的 writeNewSplits 中会调用 input.getSplits(job) 进行切片
        // 我们使用的默认InputFormat，也就是 TextInputFormat。TextInputFormat 的 getSplits 方法在 FileInputFormat（TextInputFormat的父类）中
        // FileInputFormat 的 getSplits 方法会调用makeSplit创建 FileSplit 类型的切片对象
        fileName = ((FileSplit) context.getInputSplit()).getPath().getName();
    }

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, OrderInfo>.Context context) throws IOException, InterruptedException {
        String[] valueArray = value.toString().split("@");

        logger.info("---------------------------------------------------------");
        logger.info("fileName:" + fileName);

        OrderInfo orderInfo = new OrderInfo();
        if(fileName.startsWith("order")) { // 处理 order.txt文件的内容
            orderInfo.setId(valueArray[0]);
            orderInfo.setPid(valueArray[1]);
            orderInfo.setAmount(Integer.valueOf(valueArray[2]));
            orderInfo.set_from_table("_ORDER_"); // 设置来源表为order表
            orderInfo.setPname(""); // 属性值不能有null，否则会报NPE空指针异常。可以设置一个默认值

            outKey.set(valueArray[1]);
        } else { // 处理 product.txt文件的内容
            orderInfo.setPid(valueArray[0]);
            orderInfo.setPname(valueArray[1]);
            orderInfo.set_from_table("_PRODUCT_"); // 设置来源表为product
            // 防止空指针异常，对null属性设置一个默认值
            orderInfo.setId("");
            orderInfo.setAmount(-1);

            outKey.set(valueArray[0]);
        }
        context.write(outKey, orderInfo);

        logger.info(orderInfo);
        logger.info("-------------------------------------------");
    }
}