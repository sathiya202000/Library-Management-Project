package com.example.librarymanagementsystem.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "returns")
public class Return {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long returnId;

    @Column(name = "book_title", nullable = false)
    private String bookTitle;

    @Column(name = "returned_by", nullable = false)
    private String returnedBy;

    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;

    // Getters and Setters
    public Long getReturnId() {
        return returnId;
    }

    public void setReturnId(Long returnId) {
        this.returnId = returnId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getReturnedBy() {
        return returnedBy;
    }

    public void setReturnedBy(String returnedBy) {
        this.returnedBy = returnedBy;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
