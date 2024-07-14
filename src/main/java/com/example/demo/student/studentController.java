/**
 * @Author Eman Hashim
 * Project Name   Spring Boot Serious For Beginners
 * Date : 7/12/2024
 * Time: 3:33 AM
 */


package com.example.demo.student;


//this page has all the API layers of all or the routing happens here

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;



@RestController
@RequestMapping(path = "api/v1/student")
public class studentController {


  // we use a reference or dependency injection to get an access of the business login
    // which is the service class to make it happen we call it like below
    // below we call service class along with its constructor




    private final StudentService studentService;

    @Autowired   //this is used for a auto initiation a class it self auto initiate a class we call, and inject it
    public studentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //we use this to store data from our static side(configurationClass)
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }


    @PostMapping
    //here the method is to  post data from client side
    public void registerNewStudent(@RequestBody Student student){
        //we invoke the service
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable ("studentId") Long studentId){
        studentService.deleteStudentById(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId,name,email);
    }


}
