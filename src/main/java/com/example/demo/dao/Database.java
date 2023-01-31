package com.example.demo.dao;

import com.example.demo.model.Author;
import com.example.demo.model.Book;


import java.util.ArrayList;
import java.util.List;
public class Database {

    private static Database singleton_Database = null;
    private final List<Author> authorsDB  = new ArrayList<>();
    private final List<Book> bookDB = new ArrayList<>();


    private Database(){
    }

    public static Database getInstance(){
        if (singleton_Database == null){
            singleton_Database = new Database();
        }
        return singleton_Database;
    }

    public List<Author> getAuthorsDB() {
        return authorsDB;
    }

    public List<Book> getBookDB() {
        return bookDB;
    }
}
