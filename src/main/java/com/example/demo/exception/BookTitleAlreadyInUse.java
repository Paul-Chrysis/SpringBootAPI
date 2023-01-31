package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BookTitleAlreadyInUse extends RuntimeException{
    private final String title;

    public BookTitleAlreadyInUse(String title) {
        super(title + " is the title of another book");
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
