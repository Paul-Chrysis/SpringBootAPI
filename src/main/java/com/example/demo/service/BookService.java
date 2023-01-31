package com.example.demo.service;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {

    private final AuthorService authorService;
    private final BookDao bookDao;

    public BookService(AuthorService authorService, @Qualifier("fakeBookDao") BookDao bookDao){
        this.authorService = authorService;
        this.bookDao = bookDao;}
    public UUID createBook(UUID authorId, Book book){
        Optional<Author> authorOfBook=authorService.getAuthorById(authorId);
        if(authorOfBook.isPresent()) {
            return bookDao.insertBook(authorId, book);
        }else{
            return null;
        }
    }
    public List<Book> getAllBooks(){return bookDao.getAllBookList();}
    public Optional<Book> getBookById(UUID bookId){return bookDao.getBookById(bookId);}
    public UUID deleteBookById(UUID bookId){return bookDao.deleteBookById(bookId);}
}
