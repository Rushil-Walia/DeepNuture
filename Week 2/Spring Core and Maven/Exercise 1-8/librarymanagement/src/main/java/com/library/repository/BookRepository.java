package com.library.repository;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    public void saveBook(String bookName) {
        System.out.println("Saving book to database: " + bookName);
    }
}