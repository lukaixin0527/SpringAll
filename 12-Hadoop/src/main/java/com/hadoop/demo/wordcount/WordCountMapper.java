package com.hadoop.demo.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

/*
 * Mapper泛型：
 * 输入的key类型：本程序需要将偏移量当做key，所以是LongWritable类型
 * 输入的value类型：一般都是文本字符串，所以是Text类型
 * 输出的key类型：本程序的Mapper输出的是单词数量，所以key是单词，Text类型
 * 输出的value类型：单词的个数，所以是IntWritable类型
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    private Text outKey = new Text();
    // 因为我们map阶段不聚合，每个单词出现一次就记一个1
    private IntWritable outValue = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context) throws IOException, InterruptedException {

        String line = value.toString();   // 获取一行信息
        String[] words = line.split(" ");  // 拆分一行内容中的单词

        for (String word : words) {
            outKey.set(word);// 将word转换成Text类型
            // 将 key-value 输出到 context 中，供后面的Reducer使用
            context.write(outKey, outValue); // xxx单词出现了1次
        }

    }
}
