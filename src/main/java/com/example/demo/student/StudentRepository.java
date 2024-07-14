package com.example.demo.student;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//this interface suppose to be used for connecting our class, db, and services <db, id we generated at our student class>
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    //we need to check weather the mail signedup exists or not

     @Query("SELECT s FROM Student s WHERE s.email =?1")

    Optional<Student> findStudentByEmail(String email);

}
