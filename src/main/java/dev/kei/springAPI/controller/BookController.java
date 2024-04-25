package dev.kei.springAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.kei.springAPI.model.Book;
import dev.kei.springAPI.service.BookService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book saveBook(@Valid @RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @DeleteMapping
    public void deleteAllBook() {
        bookService.deleteAllBook();
    }

    @DeleteMapping("/{id}")
    public void deleteAllBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }
}
