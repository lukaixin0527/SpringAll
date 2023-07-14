package com.hadoop.demo.flow;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FlowReducer extends Reducer<Text, FlowBean, Text, FlowBean> {

    private FlowBean flowBean = new FlowBean();

    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Reducer<Text, FlowBean, Text, FlowBean>.Context context) throws IOException, InterruptedException {

        // 遍历集合累计求和
        long totalUp = 0;
        long totalDown = 0;
        for (FlowBean flowBean : values) {
            totalUp += flowBean.getUpFlow();
            totalDown += flowBean.getDownFlow();
        }
        // 封装
        flowBean.setUpFlow(totalUp);
        flowBean.setDownFlow(totalDown);
        flowBean.setSumFlow();

        // 写出
        context.write(key, flowBean);
    }
}
