/**
 * @Author Eman Hashim
 * Project Name   Spring Boot Serious For Beginners
 */






package com.example.demo.student;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.Period;


@Entity // this allows as to map through our db from our class or model  also this is for hibernate
@Table // this for the tables

public class Student {

    public Student() {
    }

    @Id // this is we trying to put default id

    @SequenceGenerator(name= "student_sequence",
                                sequenceName = "student_sequence",
                                        allocationSize = 1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )


    // here we uses logn ID for the REpository
    private long Id;
    private String name;
    private String email;


    private LocalDate dob;

    @Transient  //this will allow us to calculate age from date of birth to current date or dont need to be inserted directly in db column
    private Integer age;


    //a constrcutor with none or default
    public Student(long l, String name, String mail, LocalDate dob, int id) {
    }





    //all included constructor
    public Student(
            String name,
            String email,
                   LocalDate dob,


                   long id) {
        this.name = name;

        this.email = email;
        this.dob = dob;
        Id = id;
    }

    //constructor to all with out id, since the db generates the id by default


    public Student(

                   String name,
                   String email,
                   LocalDate dob
                  ) {


        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }
//generate getters and setters for all


    //generate tostring
    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }


}
