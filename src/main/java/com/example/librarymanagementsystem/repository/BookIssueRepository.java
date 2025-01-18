package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.model.BookIssue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookIssueRepository extends JpaRepository<BookIssue, Long> {
}
