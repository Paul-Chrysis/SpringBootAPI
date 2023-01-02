package com.example.demo.service;

import com.example.demo.dao.AuthorDao;
import com.example.demo.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {
    private final AuthorDao authorDao;
    @Autowired
    public AuthorService(@Qualifier("fakeDao") AuthorDao authorDao){
        this.authorDao =authorDao;
    }

    public UUID addAuthor(Author author){
        return authorDao.insertAuthor(author);
    }
    public List<Author> getAuthors(){
        return authorDao.getAuthors();
    }
    public Optional<Author> getAuthorById(UUID id){
        return authorDao.getAuthorById(id);
    }
    public void removeAuthor(UUID id){
         authorDao.deleteAuthor(id);
    }
    public void updateAuthor(UUID id, String address, int phoneNumber, String email){
        authorDao.updateAuthor(id,address,phoneNumber,email);
    }
}
