package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/query/{id}", method = RequestMethod.GET)
    public Student query(@PathVariable("id") Integer id) {
        return this.studentService.queryStudentById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Integer add(@RequestBody Student student) {
        return this.studentService.add(student);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Integer delete(@PathVariable("id") Integer id) {
        return this.studentService.deleteById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Integer update(@RequestBody Student student) {
        return this.studentService.update(student);
    }
}
