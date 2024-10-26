package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.AppUser;
import com.example.librarymanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(AppUser user) {
        // Encrypt the user's password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Set default role
        user.setRole("ROLE_USER");
        userRepository.save(user);
    }

    public boolean usernameExists(String username) {
        return userRepository.findByUsername(username) != null;
    }
}
