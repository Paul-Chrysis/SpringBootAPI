package com.example.demo.dao;

import com.example.demo.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository("fakeDao")
public class FakeAuthorDataAccessService implements AuthorDao{
    private static List<Author> DB = new ArrayList<>();

    @Override
    public UUID insertAuthor(UUID id,Author author) {
        DB.add(new Author(id,author.getName(), author.getSurname(), author.getAddress(), author.getphoneNumber(), author.getEmail()));
        return id;
    }

    @Override
    public List<Author> getAuthors() {
        return DB;
    }

    @Override
    public Optional<Author> getAuthorById(UUID id) {
        return DB.stream().filter(author -> author.getId().equals(id)).findFirst();
    }

}
