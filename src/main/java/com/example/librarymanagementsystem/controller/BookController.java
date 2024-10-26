package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        return "books/create";
    }

    @PostMapping("/create")
    public String createBook(@ModelAttribute Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "books/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book) {
        book.setId(id);
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
}
