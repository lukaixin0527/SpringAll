package com.hadoop.demo.writable;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.text.MessageFormat;

/**
 * 序列化
 */
public class MyWritable implements Writable, Comparable<MyWritable> {
    private Integer id;
    private Long scale;
    private Integer age;

    /**
     * 需要有无参构造器
     */
    public MyWritable() {
    }

    /**
     * 序列化
     *
     * @param dataOutput
     * @throws IOException
     */
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(id);
        dataOutput.writeLong(scale);
        dataOutput.writeInt(age);
    }

    /**
     * 反序列化
     *
     * @param dataInput
     * @throws IOException
     */
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        // 读取顺序要和write方法写的顺序一致，即先进先出
        id = dataInput.readInt();
        scale = dataInput.readLong();
        age = dataInput.readInt();
    }

    /**
     * 如果想当做key在MapReduce中传输，需要实现Comparable，因为Shuffle过程要求key必须能排序
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(MyWritable o) {
        return this.id > o.getId() ? -1 : 1;
    }

    /**
     * 为方便查看，还可以重写toString()方法      * @return
     */
    @Override
    public String toString() {
        MessageFormat mf = new MessageFormat("MyWritable:{id:[0], scale:[1], age:[2]}");
        return mf.format(new Object[]{id, scale, age});
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getScale() {
        return scale;
    }

    public void setScale(Long scale) {
        this.scale = scale;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
