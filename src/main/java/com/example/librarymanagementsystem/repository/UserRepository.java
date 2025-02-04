package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
