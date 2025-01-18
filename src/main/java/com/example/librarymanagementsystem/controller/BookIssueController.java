package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.BookIssue;
import com.example.librarymanagementsystem.service.BookIssueService;
import com.example.librarymanagementsystem.service.BookService;
import com.example.librarymanagementsystem.service.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/issue")
public class BookIssueController {

    @Autowired
    private BookService bookService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private BookIssueService bookIssueService;

    // List all book issues
    @GetMapping
    public String listBookIssues(Model model) {
        List<BookIssue> bookIssues = bookIssueService.getAllIssues();
        model.addAttribute("bookIssues", bookIssues);
        return "issue/list";  // The template to render
    }

    // Show Issue Book Form
    @GetMapping("/create")
    public String showIssueForm(Model model) {
        model.addAttribute("students", studentService.getAllStudents()); // Fetch list of students
        model.addAttribute("books", bookService.getAllBooks());         // Fetch list of books
        model.addAttribute("bookIssue", new BookIssue());               // Create a new BookIssue object
        return "issue/create";  // Returns the 'create.html' page
    }

    // Process Issue Form
    @PostMapping("/create")
    public String issueBook(@ModelAttribute BookIssue bookIssue) {
        bookIssueService.saveIssue(bookIssue);  // Save the issue to the database
        return "redirect:/issue";  // Redirect to the issue list page
    }

    // Handle book return
    @PostMapping("/return/{id}")
    public String returnBook(@PathVariable Long id) {
        bookIssueService.returnBook(id);  // Process book return and update quantity
        return "redirect:/issue";  // Redirect to the issue list page
    }
}
