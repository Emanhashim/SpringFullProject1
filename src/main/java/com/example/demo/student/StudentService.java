/**
 * @Author Eman Hashim
 * Project Name   Spring Boot Serious For Beginners
 * Date : 7/12/2024
 * Time: 3:49 AM
 */


package com.example.demo.student;

// service class is where the business model designed and all logical layers happening

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Component  // this means this is a class that can be initiated from other class or a bean that can be autowired
//we can use @service and @component its same thing only semantic difference

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    @Autowired // here we initialize with spring inorder to use repository class
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
}
