package com.example.demo.dao;

import com.example.demo.exception.AuthorAlreadySignedUp;
import com.example.demo.exception.AuthorEmailAlreadyInUse;
import com.example.demo.exception.AuthorNotFoundException;
import com.example.demo.model.Author;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeAuthorDataAccessService implements AuthorDao {
    private static final List<Author> DB = new ArrayList<>();

    @Override
    public UUID insertAuthor(UUID id, Author author) {
        DB.stream()
                .filter(authors -> authors.getEmail().equals(author.getEmail()))
                .findFirst()
                .ifPresent(a -> {
                    throw new AuthorEmailAlreadyInUse(a.getId(), author.getEmail());
                });

        DB.stream()
                .filter(authors -> authors.getSurname().equals(author.getSurname()))
                .findFirst()
                .filter(x -> x.getName().equals(author.getName()))
                .ifPresent(x -> {
                    throw new AuthorAlreadySignedUp(author.getName(), author.getSurname());
                });

        DB.add(new Author(id, author.getName(), author.getSurname(), author.getAddress(), author.getPhoneNumber(), author.getEmail()));
        return id;
    }

    @Override
    public List<Author> getAuthors() {
        return DB;
    }

    @Override
    public Optional<Author> getAuthorById(UUID id) {
        Optional<Author> IdentifiedAuthor = DB.stream().filter(author -> author.getId().equals(id)).findFirst();

        if (IdentifiedAuthor.isPresent()) {
            return IdentifiedAuthor;
        } else {
            throw new AuthorNotFoundException(id);
        }
    }

    @Override
    public void deleteAuthor(UUID id) {
        Optional<Author> authorToDelete = getAuthorById(id);
        authorToDelete.ifPresent(DB::remove);
    }

    @Override
    public void updateAuthor(UUID id, String address, String phoneNumber, String email) {
        Optional<Author> authorToUpdate = getAuthorById(id);
        authorToUpdate.ifPresent(author -> author.updateInfo(address, phoneNumber, email));
    }

}
