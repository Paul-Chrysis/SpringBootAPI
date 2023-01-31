package com.example.demo.model;

import com.example.demo.enums.Genre;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class Book {
    private final UUID bookId;

    private final UUID authorId;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private Genre genre;

    public Book(
            @JsonProperty("bookId") UUID bookId,
            @JsonProperty("authorId") UUID authorId,
            @JsonProperty("title") String title,
            @JsonProperty("description") String description,
            @JsonProperty("genre") Genre genre) {
        this.bookId = bookId;
        this.authorId = authorId;
        this.title = title;
        this.description = description;
        this.genre = genre;
    }

    public UUID getBookId() {
        return bookId;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Genre getGenre() {
        return genre;
    }
}

