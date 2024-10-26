package com.example.librarymanagementsystem.controller;
import com.example.librarymanagementsystem.model.Student;
import com.example.librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
    private StudentService studentService;

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student) {
    	studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{studentId}")
    public String showEditForm(@PathVariable Long studentId, Model model) {
        model.addAttribute("student", studentService.getStudentById(studentId));
        return "students/edit";
    }

    @PostMapping("/edit/{studentId}")
    public String updateStudent(@PathVariable Long studentId, @ModelAttribute Student student) {
    	student.setStudentId(studentId);
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{studentId}")
    public String deleteStudent(@PathVariable Long studentId) {
    	studentService.deleteStudent(studentId);
        return "redirect:/students";
    }

}
