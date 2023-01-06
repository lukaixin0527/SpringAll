package com.example.demo.service;

import com.example.demo.entity.Student;

public interface  StudentService {
    int add(Student student);
    int update(Student student);
    int deleteById(Integer id);
    Student queryStudentById(Integer id);
}
