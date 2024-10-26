package com.example.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.librarymanagementsystem.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
