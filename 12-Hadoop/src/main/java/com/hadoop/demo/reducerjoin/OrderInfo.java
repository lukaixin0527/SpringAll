package com.hadoop.demo.reducerjoin;


import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * JavaBean结果
 */
public class OrderInfo implements Writable {
    private String id;  // 订单编号
    private String pid;  // 产品编号
    private Integer amount;  // 数量
    private String pname;  // 产品名称
    private String _from_table;  // 标记该条数据的来源表：order、product

    public OrderInfo() {
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(id);  // 序列化String时，使用 writeUTF写出、readUTF读取
        out.writeUTF(pid);
        out.writeInt(amount);
        out.writeUTF(pname);
        out.writeUTF(_from_table);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        id = in.readUTF();
        pid = in.readUTF();
        amount = in.readInt();
        pname = in.readUTF();
        _from_table = in.readUTF();
    }


    // 重写toString，将JavaBean输出到文件时会调用toString方法输出
    @Override
    public String toString() {
        return "OrderInfo{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", amount=" + amount +
                ", pname='" + pname + '\'' +
                ", _from_table='" + _from_table + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String get_from_table() {
        return _from_table;
    }

    public void set_from_table(String _from_table) {
        this._from_table = _from_table;
    }
}