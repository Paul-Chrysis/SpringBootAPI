package com.example.demo.exception;

import java.util.UUID;

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
