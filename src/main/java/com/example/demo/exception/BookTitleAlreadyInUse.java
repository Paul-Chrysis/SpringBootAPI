package com.example.demo.exception;

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
