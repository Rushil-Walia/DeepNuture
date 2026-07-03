package com.library.entity;

import jakarta.persistence.*;

@Entity
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;

    // 1. Default Constructor (Required by JPA)
    public Book() {
    }

    // 2. Parameterized Constructor
    public Book(String title) {
        this.title = title;
    }

    // 3. Getters and Setters (Required by Spring/Jackson to create JSON)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}