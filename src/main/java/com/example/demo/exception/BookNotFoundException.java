package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException{
    private final UUID id;

    public BookNotFoundException(UUID id){
        super("Book with ID: " + id + " not found");
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
