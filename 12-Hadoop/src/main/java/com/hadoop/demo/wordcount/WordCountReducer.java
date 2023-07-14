package com.hadoop.demo.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

/**
 * Reducer泛型：
 * 输入的key类型：单词字符串，即Mapper的输出的key类型
 * 输入的value类型：单词出现次数（因为map没有聚合，所以每个value都是1）即mapper的输出的value类型
 * 输出的key类型：单词，所以是Text类型
 * 输出的value类型：汇总的单词个数，所以是IntWritable类型
 */
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    IntWritable outValue = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {

        int sum = 0;
        for (IntWritable value : values) {
            sum += value.get(); // value是IntWritable类型，需要调用get()进行类型转换
        }
        outValue.set(sum);
        context.write(key, outValue);
    }
}
