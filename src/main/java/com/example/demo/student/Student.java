/**
 * @Author Eman Hashim
 * Project Name   Spring Boot Serious For Beginners
 */






package com.example.demo.student;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity // this allows as to map through our db from our class or model  also this is for hibernate
@Table // this for the tables

public class Student {

    @Id // this is we trying to put default id

    @SequenceGenerator(name= "student_sequence",
                                sequenceName = "student_sequence",
                                        allocationSize = 1)

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private long Id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;


    //a constrcutor with none or default
    public Student(long l, String susu, String mail, LocalDate localDate, int id) {
    }


    //all included constructor
    public Student(Integer age,
                   LocalDate dob,
                   String email,
                   String name,
                   long id) {
        this.age = age;
        this.dob = dob;
        this.email = email;
        this.name = name;
        Id = id;
    }

    //constructor to all with out id, since the db generates the id by default


    public Student(Integer age,
                   LocalDate dob,
                   String email,
                   String name) {
        this.age = age;
        this.dob = dob;
        this.email = email;
        this.name = name;
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
        return age;
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
