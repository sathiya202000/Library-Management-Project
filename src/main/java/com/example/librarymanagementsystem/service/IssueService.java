package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.Issue;
import com.example.librarymanagementsystem.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    public Issue getIssueById(Long issueId) {
        return issueRepository.findById(issueId).orElse(null);
    }

    public void saveIssue(Issue issue) {
        issueRepository.save(issue);
    }

    public void deleteIssue(Long issueId) {
        issueRepository.deleteById(issueId);
    }
}
