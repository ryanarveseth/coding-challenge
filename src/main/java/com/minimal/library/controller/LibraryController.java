package com.minimal.library.controller;

import com.minimal.library.model.Book;
import com.minimal.library.repo.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class LibraryController {

    /*
        I didn't create a service because of how simple this api is...
        If it were more complex, I'd use a service to handle the saves,
        gets, and updates.
     */

    @Autowired
    LibraryRepo libraryRepo;

    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        libraryRepo.save(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/read")
    public List<Book> readAllBooks() {
        return libraryRepo.findAll();
    }

    @GetMapping("/read/{id}")
    public Book getBookById(@PathVariable("id") Long id) {
        return libraryRepo.findByBookId(id);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable("id") Long id, @RequestBody Book book) {
        Book bookToUpdate = libraryRepo.findByBookId(id);
        if (bookToUpdate != null) {
            bookToUpdate.setAuthor(book.getAuthor());
            bookToUpdate.setTitle(book.getTitle());
            libraryRepo.save(bookToUpdate);
            return new ResponseEntity<>(bookToUpdate, HttpStatus.OK);
        }
        return new ResponseEntity<>(new Book(), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") Long id) {
        Book bookToDelete = libraryRepo.findByBookId(id);

        if (bookToDelete != null) {
            libraryRepo.delete(bookToDelete);
            return new ResponseEntity<>("Book successfully deleted.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Book could not be found.", HttpStatus.OK);
    }
}
