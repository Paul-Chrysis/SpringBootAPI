package com.example.demo.api;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/book")
@RestController
public class BookController {
    private final BookService bookService;
    public  BookController(BookService bookService){this.bookService=bookService;}

    @PostMapping("{authorId}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UUID addBook(@PathVariable("authorId") UUID authorId, @Valid @RequestBody @NotNull Book book){
        return bookService.createBook(authorId,book);
    }

    @GetMapping
    public List<Book> getBooks(){return bookService.getAllBooks();}

    @GetMapping("{bookId}")
    public Optional<Book> getBookById(@PathVariable("bookId") UUID bookId){return bookService.getBookById(bookId);}

    @DeleteMapping("{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//NO_CONTENT(204, Series.SUCCESSFUL, "No Content")
    public UUID deleteBookById(@PathVariable("bookId")UUID bookId){return bookService.deleteBookById(bookId);}

}
