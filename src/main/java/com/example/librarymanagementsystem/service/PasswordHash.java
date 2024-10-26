package com.example.librarymanagementsystem.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHash {
	public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println(encodedPassword);
    }

}
