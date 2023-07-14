package com.hadoop.demo.reducerjoin;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class ReduceJoinDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration config = new Configuration();
        Job job = Job.getInstance(config);

        job.setJarByClass(ReduceJoinDriver.class);

        job.setMapperClass(ReduceJoinMapper.class);
        job.setReducerClass(ReduceJoinReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(OrderInfo.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(OrderInfo.class);

        FileInputFormat.setInputPaths(job, new Path("/app/order/input"));
        FileOutputFormat.setOutputPath(job, new Path("/app/order/output/output2"));

        boolean success = job.waitForCompletion(true);

        System.exit(success ? 0 : 1); // 程序退出
    }
}
