package com.example.demo.mapper;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface StudentMapper {
    @Insert("insert into student(id,name,age) values(#{id},#{name},#{age})")
    int add(Student student);

    @Update("update student set name=#{name},age=#{age} where id=#{id}")
    int update(Student student);

    @Delete("delete from student where id=#{id}")
    int deleteById(Integer id);

    @Select("select * from student where id=#{id}")
    @Results(id = "student", value = {
            @Result(property = "id", column = "id", javaType = Integer.class),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "age", column = "age", javaType = Integer.class)
    })
    Student queryStudentById(Integer id);
}
