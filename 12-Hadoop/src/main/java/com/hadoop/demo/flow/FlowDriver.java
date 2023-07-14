package com.hadoop.demo.flow;

import com.hadoop.demo.wordcount.WordCountDriver;
import com.hadoop.demo.wordcount.WordCountMapper;
import com.hadoop.demo.wordcount.WordCountReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class FlowDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

        // 1. 获取job
        Configuration config = new Configuration();
        Job job = Job.getInstance(config);

        // 2.设置 jar 路径
        job.setJarByClass(FlowDriver.class);// 可以直接通过当前类的全类名反射获取到jar包路径

        // 3.关联mapper和reducer
        job.setMapperClass(FlowMapper.class);
        job.setReducerClass(FlowReducer.class);

        // 4.设置map输出的key、value类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);

        // 5.设置最终输出（最终输出不一定是Reducer输出）的key、value类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        // 6.设置输入路径和输出路径
        FileInputFormat.setInputPaths(job, new Path("D:\\Hadoop\\input2"));  // 本地文件路径，可以输入多个
        FileOutputFormat.setOutputPath(job, new Path("D:\\Hadoop\\output2"));  // 本地文件路径(需要是一个不存在的文件夹,否则会报错目录已存在)
//        FileInputFormat.setInputPaths(job, new Path(args[0]));
//        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // 可以调用 job.submit() 提交作业
        // 但是为了调试，可以调用waitForCompletion,传入一个true，让程序输出监控信息
        // waitForCompletion内部也是调用了 job.submit()
        boolean success = job.waitForCompletion(true);
        System.exit(success ? 0 : 1);  // 程序退出

    }
}
