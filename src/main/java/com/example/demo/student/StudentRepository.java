package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//this interface suppose to be used for connecting our class, db, and services <db, id we generated at our student class>
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {




}
