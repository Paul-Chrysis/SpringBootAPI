package com.example.demo.dao;

import com.example.demo.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookDao {
    UUID insertBook(UUID bookId,UUID authorId, Book book);

    default UUID insertBook(UUID authorId, Book book){
        UUID bookId =  UUID.randomUUID();
        return insertBook(bookId,authorId,book);
    }

    List<Book> getAllBookList();
    Optional<Book> getBookById(UUID bookId);

    UUID deleteBookById(UUID bookId);
}
