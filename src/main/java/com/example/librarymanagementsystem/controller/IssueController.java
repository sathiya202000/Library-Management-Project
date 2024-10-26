package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.Issue;
import com.example.librarymanagementsystem.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/issues")
public class IssueController {

    @Autowired
    private IssueService issueService;

    @GetMapping
    public String listIssues(Model model) {
        List<Issue> issues = issueService.getAllIssues();
        model.addAttribute("issues", issues);
        return "issues/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("issue", new Issue());
        return "issues/create";
    }

    @PostMapping("/create")
    public String createIssue(@ModelAttribute Issue issue) {
        issueService.saveIssue(issue);
        return "redirect:/issues";
    }

    @GetMapping("/edit/{issueId}")
    public String showEditForm(@PathVariable Long issueId, Model model) {
        Issue issue = issueService.getIssueById(issueId);
        if (issue == null) {
            return "redirect:/issues";
        }
        model.addAttribute("issue", issue);
        return "issues/edit";
    }

    @PostMapping("/edit/{issueId}")
    public String updateIssue(@PathVariable Long issueId, @ModelAttribute Issue issue) {
        issue.setIssueId(issueId);
        issueService.saveIssue(issue);
        return "redirect:/issues";
    }

    @GetMapping("/delete/{issueId}")
    public String deleteIssue(@PathVariable Long issueId) {
        issueService.deleteIssue(issueId);
        return "redirect:/issues";
    }
}
