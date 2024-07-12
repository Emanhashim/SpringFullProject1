/**
 * @Author Eman Hashim
 * Project Name   Spring Boot Serious For Beginners
 * Date : 7/12/2024
 * Time: 6:02 AM
 */


package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.AUGUST;

@Configuration

public class StudentConfiguration {

    @Bean  // used to run
    CommandLineRunner commandLineRunner(StudentRepository repository){

return args -> {

    Student mariam = new Student(

            "kira",
            "aa@gmail.com",
            LocalDate.of(1997, AUGUST,30)
    );

    Student rora = new Student(

            "mami",
            "hawa@gmail.com",
            LocalDate.of(1989, AUGUST,2)


    );

    repository.saveAll(List.of(mariam, rora));



};
    }
}
