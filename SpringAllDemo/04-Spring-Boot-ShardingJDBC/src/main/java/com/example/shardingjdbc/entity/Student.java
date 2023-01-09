package com.example.shardingjdbc.entity;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    private static final long serialVersionUID = -339516038496531943L;

    private Integer id;
    private String name;
    private Integer age;
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", createTime=" + createTime +
                '}';
    }
}
