/**
 * @Author Eman Hashim
 * Project Name   Spring Boot Serious For Beginners
 * Date : 7/12/2024
 * Time: 3:49 AM
 */


package com.example.demo.student;

// service class is where the business model designed and all logical layers happening

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


// @Component  // this means this is a class that can be initiated from other class or a bean that can be autowired
//we can use @service and @component its same thing only semantic difference

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    @Autowired // here we initialize with spring inorder to use repository class
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    //    //this method for post students
    public void addNewStudent(Student student) {

        System.out.println(student);
//here the algorithm to check the student by mail

        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email already taken");
        }
        studentRepository.save(student);

    }

    //this is the logic to delete students by id

    public void deleteStudentById(Long studentId) {

        boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException(
                    "student with id" + studentId + "doesnt exist"
            );
                }
        studentRepository.deleteById(studentId);
    }


    //this is to update a student
    @Transactional

    public void updateStudent(Long studentId,
                              String name,
                              String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with this " + studentId+ "doesnt exist"
                ));
        if(name != null && name.length() > 0 &&
        !Objects.equals(student.getName(), name
        )){ student.setName(name);
        }


        if(email != null && email.length() > 0 &&
                !Objects.equals(student.getEmail(), email
                )){

            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }



    }
}
