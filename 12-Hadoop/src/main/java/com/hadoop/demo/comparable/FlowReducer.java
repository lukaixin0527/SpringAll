package com.hadoop.demo.comparable;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FlowReducer extends Reducer<FlowBeanComparable, Text, Text, FlowBeanComparable> {


    @Override
    protected void reduce(FlowBeanComparable key, Iterable<Text> values, Reducer<FlowBeanComparable, Text, Text, FlowBeanComparable>.Context context) throws IOException, InterruptedException {
        for (Text value : values) {
            // 写出
            context.write(value, key);
        }
    }

}
