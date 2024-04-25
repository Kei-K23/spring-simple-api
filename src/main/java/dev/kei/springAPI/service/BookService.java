package dev.kei.springAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.kei.springAPI.model.Book;
import dev.kei.springAPI.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteAllBook(Long id) {
        bookRepository.deleteAll();
    }

    public boolean deleteBookById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);

        if (bookOptional.isPresent()) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
