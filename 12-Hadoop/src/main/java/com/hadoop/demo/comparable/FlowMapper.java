package com.hadoop.demo.comparable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlowMapper extends Mapper<LongWritable, Text, FlowBeanComparable, Text> {

    private FlowBeanComparable outK = new FlowBeanComparable();
    private Text outV = new Text();

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, FlowBeanComparable, Text>.Context context) throws IOException, InterruptedException {
        // 获取每一行数据
        String line = value.toString();
        String[] split = line.split(" ");
        // 抓取想要的数据


        // 封装
        outV.set(split[0]);
        outK.setUpFlow(Long.parseLong(split[1]));
        outK.setDownFlow(Long.parseLong(split[2]));
        outK.setSumFlow();
        // 写出
        context.write(outK, outV);
    }
}
