package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.AppUser;
import com.example.librarymanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new AppUser());
        return "register";
    }

    @PostMapping
    public String registerUser(AppUser user, Model model) {
        // Check if username already exists
        if (userService.usernameExists(user.getUsername())) {
            model.addAttribute("error", "Username already exists");
            return "register";
        }

        // Register the user
        userService.registerUser(user);
        return "redirect:/login?registered=true";
    }
}
