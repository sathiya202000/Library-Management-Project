package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.model.BookIssue;
import com.example.librarymanagementsystem.model.Student;
import com.example.librarymanagementsystem.repository.BookIssueRepository;
import com.example.librarymanagementsystem.repository.BookRepository;
import com.example.librarymanagementsystem.repository.StudentRepository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookIssueService {

    @Autowired
    private BookIssueRepository bookIssueRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private StudentRepository studentRepository;

    // Save a new book issue
    public void saveIssue(BookIssue bookIssue) {
        // Ensure the book and student exist
        Book book = bookRepository.findById(bookIssue.getBook().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID"));
        Student student = studentRepository.findById(bookIssue.getStudent().getStudentId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));

        // Set the student and book
        bookIssue.setBook(book);
        bookIssue.setStudent(student);

        // Check book availability and save issue record
        if (book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
            bookRepository.save(book);
            bookIssueRepository.save(bookIssue);
        } else {
            throw new IllegalArgumentException("Not enough books available for issue.");
        }
    }

    // Fetch all book issues
    public List<BookIssue> getAllIssues() {
        return bookIssueRepository.findAll();
    }

    // Handle returning a book
    public void returnBook(Long issueId) {
        // Fetch the issue record
        BookIssue issue = bookIssueRepository.findById(issueId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid issue ID"));

        // Update book quantity
        Book book = issue.getBook();
        book.setQuantity(book.getQuantity() + 1);
        bookRepository.save(book);

        // Delete the issue record (or alternatively mark as returned)
        bookIssueRepository.delete(issue);
    }

    // Get the return status for a book issue
    public String getReturnStatus(BookIssue bookIssue) {
        LocalDate today = LocalDate.now();
        LocalDate returnDate = bookIssue.getReturnDate();

        if (returnDate.isBefore(today)) {
            return "Overdue";
        } else if (returnDate.isEqual(today) || returnDate.isAfter(today)) {
            return "Due for Return";
        }
        return "Unknown";
    }
}
