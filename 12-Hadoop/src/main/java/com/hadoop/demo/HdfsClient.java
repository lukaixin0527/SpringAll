package com.hadoop.demo;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HdfsClient {

    private FileSystem fs;

    @Before
    /**
     * 获取客户端对象
     */
    public void init() throws URISyntaxException, IOException, InterruptedException {
        Configuration configuration = new Configuration();
        // 连接的集群NN地址
        String uri = "hdfs://hadoop102:8020";
        // 用户
        String user = "lukaixin";

        fs = FileSystem.get(new URI(uri), configuration, user);
    }

    @After
    /**
     * 关闭资源
     */
    public void close() throws IOException {
        fs.close();
    }

    @Test
    public void testMkdirs() throws IOException, URISyntaxException, InterruptedException {
        // 在HDFS上创建一个文件夹
        fs.mkdirs(new Path("/uploadTest02"));
    }
}
