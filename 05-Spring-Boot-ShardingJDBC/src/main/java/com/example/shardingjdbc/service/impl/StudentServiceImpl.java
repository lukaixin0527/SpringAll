package com.example.shardingjdbc.service.impl;

import com.example.shardingjdbc.entity.Student;
import com.example.shardingjdbc.mapper.StudentMapper;
import com.example.shardingjdbc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int add(Student student) {
        return this.studentMapper.add(student);
    }

    @Override
    public int update(Student student) {
        return this.studentMapper.update(student);
    }

    @Override
    public int deleteById(Integer id) {
        return this.studentMapper.deleteById(id);
    }

    @Override
    public Student queryStudentById(Integer id) {
        return this.studentMapper.queryStudentById(id);
    }
}
