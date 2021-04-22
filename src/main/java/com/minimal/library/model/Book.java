package com.minimal.library.model;

import javax.persistence.*;

/* This table resides in an in-memory database. */
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Long bookId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    public Book() {
        super();
    }

    public Book(Book book) {
        this.bookId = book.bookId;
        this.title = book.title;
        this.author = book.author;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
