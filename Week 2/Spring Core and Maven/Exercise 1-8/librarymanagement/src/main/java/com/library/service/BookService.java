package com.library.service;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    private BookRepository bookRepository;

    // Constructor Injection (Exercise 7)
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository injected via Constructor.");
    }

    // Setter Injection (Exercise 2 & 7)
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository injected via Setter.");
    }

    public void addBook(String bookName) {
        bookRepository.saveBook(bookName);
    }
}