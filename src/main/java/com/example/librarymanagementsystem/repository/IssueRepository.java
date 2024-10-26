package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
