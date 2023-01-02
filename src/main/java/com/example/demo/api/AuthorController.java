package com.example.demo.api;

import com.example.demo.model.Author;
import com.example.demo.model.AuthorInfo;
import com.example.demo.service.AuthorService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/author")
@RestController
public class AuthorController {
    private final AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @PostMapping
    public UUID addAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }
    @GetMapping
    public List<Author> getAuthors(){return authorService.getAuthors();}
    @GetMapping(path = "{id}")
    public Author getAuthorById(@PathVariable("id") UUID id) {return authorService.getAuthorById(id).orElse(null);}
    @DeleteMapping(path = "{id}")
    public void deleteAuthor(@PathVariable("id") UUID id) {authorService.removeAuthor(id);}
    @PutMapping(path = "{id}")
    public void updateAuthor(@PathVariable("id") UUID id, @RequestBody @NotNull AuthorInfo authorInfo){
        authorService.updateAuthor(id, authorInfo.address(), authorInfo.phoneNumber(), authorInfo.email());
    }

}
