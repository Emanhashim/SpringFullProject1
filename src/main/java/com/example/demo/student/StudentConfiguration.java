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

@Configuration
public class StudentConfiguration {

    @Bean  // used to run
    CommandLineRunner commandLineRunner(StudentRepository repository){

return args -> {

    Student mariam = new Student(

            "mery",
            "aa@gmail.com",
            LocalDate.of(1997, Month.AUGUST,30)
    );

    Student rora = new Student(

            "eman",
            "emu@gmail.com",
            LocalDate.of(1920, Month.AUGUST,30)


    );

    repository.saveAll(List.of(mariam, rora));



};
    }
}
