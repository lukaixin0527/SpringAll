package com.example.shardingjdbc.mapper;

import com.example.shardingjdbc.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Mapper
public interface StudentMapper {

    @Insert("insert into student(id,name,age,create_time) values(#{id},#{name},#{age},#{createTime})")
    int add(Student student);

    @Update("update student set name=#{name},age=#{age} where id=#{id}")
    int update(Student student);

    @Insert("INSERT INTO student(id,name,age,create_time)\n" +
            "select id,name,age,create_time from student_last")
    int insertAll();

    @Delete("delete from student where id=#{id}")
    int deleteById(Integer id);

    @Select("select * from student where id=#{id}")
    @Results(id = "student", value = {
            @Result(property = "id", column = "id", javaType = Integer.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "age", column = "age", javaType = Integer.class),
            @Result(property = "createTime", column = "create_time", javaType = Date.class)
    })
    Student queryStudentById(Integer id);


    @Select("select * from student where name=#{name}")
    @Results(id = "studentByName", value = {
            @Result(property = "id", column = "id", javaType = Integer.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "age", column = "age", javaType = Integer.class),
            @Result(property = "createTime", column = "create_time", javaType = Date.class)
    })
    List<Student>  queryStudentByName(String name);

    @Select("select * from student where name=#{name} limit #{pageIndex},#{pageSize}")
    @Results(id = "queryStudentPageByName", value = {
            @Result(property = "id", column = "id", javaType = Integer.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "age", column = "age", javaType = Integer.class),
            @Result(property = "createTime", column = "create_time", javaType = Date.class)
    })
    List<Student> queryStudentPageByName(String name,Integer pageIndex,Integer pageSize);

    @Select("select count(1) from student ")
    Long count();

    @Select("select * from student where create_time=#{createTime}")
    @Results(id = "studentByCreateTime", value = {
            @Result(property = "id", column = "id", javaType = Integer.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "age", column = "age", javaType = Integer.class),
            @Result(property = "createTime", column = "create_time", javaType = Date.class)
    })
    List<Student> queryStudentByCreatTime(Date createTime);

    @Select("select * from student where create_time=#{createTime} limit #{pageIndex},#{pageSize}")
    @Results(id = "queryStudentPageByCreateTime", value = {
            @Result(property = "id", column = "id", javaType = Integer.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "age", column = "age", javaType = Integer.class),
            @Result(property = "createTime", column = "create_time", javaType = Date.class)
    })
    List<Student> queryStudentPageByCreateTime(Date createTime,Integer pageIndex,Integer pageSize);
}
