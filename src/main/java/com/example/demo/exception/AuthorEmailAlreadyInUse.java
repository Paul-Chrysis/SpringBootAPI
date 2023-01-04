package com.example.demo.exception;

import java.util.UUID;

public class AuthorEmailAlreadyInUse extends RuntimeException {
    private final UUID id;
    private final String email;

    public AuthorEmailAlreadyInUse(UUID id,String email){
        super("The Email that was provided is already in use");
        this.id = id;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
