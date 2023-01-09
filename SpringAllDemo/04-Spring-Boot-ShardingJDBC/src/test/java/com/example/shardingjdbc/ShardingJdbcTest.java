package com.example.shardingjdbc;

import cn.hutool.core.date.LocalDateTimeUtil;

import com.example.shardingjdbc.entity.Student;
import com.example.shardingjdbc.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class ShardingJdbcTest {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 新增
     *
     * @throws ParseException
     */
    @Test
    public void insert() throws ParseException {
        LocalDateTime localDateTime = LocalDateTimeUtil.parse("2022-01-01 00:00:00","yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < 730; i++) {
            Student student = new Student();
            student.setId(i);
            student.setName("小红");
            student.setAge(10);
            // 日期+n天
            LocalDateTime offset = LocalDateTimeUtil.offset(localDateTime, i, ChronoUnit.DAYS);
            student.setCreateTime(simpleDateFormat.parse(LocalDateTimeUtil.format(offset,"yyyy-MM-dd HH:mm:ss")));
            studentMapper.add(student);
            System.out.println(student);
        }
    }

    /**
     * 根据指定的分片 查询
     *
     * @throws ParseException
     */
    @Test
    public void query() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Date parse = simpleDateFormat.parse("2022-01-01 00:00:00");
        List<Student> students = studentMapper.queryStudentByCreatTime(parse);
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("根据分片字段 create_time 查询完成 =============");
        students = studentMapper.queryStudentByName("小红");
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("根据非分片字段 name 查询完成 =============");
    }

    /**
     * 查询总条数
     */
    @Test
    public void counts() {
        System.out.println("总数据条数:" + studentMapper.count());
    }

    /**
     * 分页查询
     */
    @Test
    public void findByPage() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        Date parse = simpleDateFormat.parse("2022-01-01 00:00:00");
        List<Student> students = studentMapper.queryStudentPageByCreateTime(parse, 0, 5);
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("根据分片字段 create_time 分页 查询完成 =============");

        students = studentMapper.queryStudentPageByName("小红", 0, 5);
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("根据分片字段 name 分页 查询完成 =============");
    }
}

