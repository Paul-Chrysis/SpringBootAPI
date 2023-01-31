package com.example.demo.dao;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.exception.BookTitleAlreadyInUse;
import com.example.demo.model.Book;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeBookDao")
public class FakeBookDataAccessService implements BookDao {

    private static final Database DATABASE = Database.getInstance();
    private static final List<Book> DB = DATABASE.getBookDB();



    @Override
    public UUID insertBook(UUID bookId, UUID authorId, @NotNull Book book) {
        DB.stream()
                .filter(books -> books.getTitle().equals(book.getTitle()))
                .findFirst()
                .ifPresent( a -> {throw new BookTitleAlreadyInUse(book.getTitle());});
        DB.add(new Book(bookId,authorId,book.getTitle(),book.getDescription(),book.getGenre()));
        return bookId;
    }

    @Override
    public List<Book> getAllBookList() {
        return DB;
    }

    @Override
    public Optional<Book> getBookById(UUID bookId) {
        Optional<Book> optionalBook = DB.stream()
                .filter(books -> books.getBookId().equals(bookId))
                .findFirst();
        if(optionalBook.isPresent()){
            return optionalBook;
        }else{
            throw new BookNotFoundException(bookId);
        }
    }

    @Override
    public UUID deleteBookById(UUID bookId) {
        Optional<Book> bookToDelete = getBookById(bookId);
        bookToDelete.ifPresent(DB::remove);
        return bookId;
    }
}
