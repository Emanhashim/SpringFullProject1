/**
 * @Author Eman Hashim
 * Project Name   Spring Boot Serious For Beginners
 * Date : 7/12/2024
 * Time: 3:33 AM
 */


package com.example.demo.student;


//this page has all the API layers of all or the routing happens here

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;



@RestController   // this annotiation makes the class below to serve as a controller
@RequestMapping (path = "api/v1/student")  // this is the path or URL to be shown while pagging from one to two

public class studentController {


  // we use a reference or dependency injection to get an access of the business login
    // which is the service class to make it happen we call it like below
    // below we call service class along with its constructor


    @Autowired   //this is used for a auto initiation a class it self auto initiate a class we call, and inject it

    private final StudentService studentService;

    public studentController(StudentService studentService) {
        this.studentService = studentService;
    }







}
