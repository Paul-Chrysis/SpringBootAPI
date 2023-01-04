package com.example.demo.exception;

public class AuthorAlreadySignedUp extends RuntimeException{
    private final String name;
    private final String surname;

    public AuthorAlreadySignedUp(String name, String surname){
        super(name + " " + surname +" is already Signed Up");
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
