package com.example.librarymanagementsystem.service;
import com.example.librarymanagementsystem.model.Student;
import com.example.librarymanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

	 @Autowired
	    private StudentRepository studentRepository;

	    public List<Student> getAllStudents() {
	        return studentRepository.findAll();
	    }

	    public Student getStudentById(Long studentId) {
	        return studentRepository.findById(studentId).orElse(null);
	    }

	    public void saveStudent(Student student) {
	        studentRepository.save(student);
	    }

	    public void deleteStudent(Long studentId) {
	    	studentRepository.deleteById(studentId);
	    }
}
