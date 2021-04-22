package com.minimal.library.repo;

import com.minimal.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibraryRepo extends JpaRepository<Book, Long> {
    List<Book> findAll();
    Book findByBookId(Long id);
}
