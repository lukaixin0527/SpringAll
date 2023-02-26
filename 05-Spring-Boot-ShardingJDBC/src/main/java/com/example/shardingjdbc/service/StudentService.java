package com.example.shardingjdbc.service;

import com.example.shardingjdbc.entity.Student;

public interface  StudentService {
    int add(Student student);
    int update(Student student);
    int deleteById(Integer id);
    Student queryStudentById(Integer id);
}
