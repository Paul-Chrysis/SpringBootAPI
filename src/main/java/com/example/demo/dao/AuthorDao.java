package com.example.demo.dao;

import com.example.demo.model.Author;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorDao {

    UUID insertAuthor(UUID id, Author author);
    default UUID insertAuthor(Author author){
        UUID id = UUID.randomUUID();
        return  insertAuthor(id, author);
    }

    List<Author> getAuthors();
    Optional<Author> getAuthorById(UUID id);


}
