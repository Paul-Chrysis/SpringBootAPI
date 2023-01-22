package com.example.demo.api;

import com.example.demo.model.Author;
import com.example.demo.model.AuthorInfo;
import com.example.demo.service.AuthorService;
import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/author")
@RestController
public class AuthorController {
    private final AuthorService authorService;
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UUID addAuthor(@Valid @RequestBody @NotNull Author author){
        return authorService.addAuthor(author);
    }

    @GetMapping
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }

    @GetMapping(path = "{id}")
    public Author getAuthorById(@PathVariable("id") UUID id) {
        return authorService.getAuthorById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)//NO_CONTENT(204, Series.SUCCESSFUL, "No Content"),
    public void deleteAuthor(@PathVariable("id") UUID id) {
        authorService.removeAuthor(id);
    }

    @PutMapping(path = "{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateAuthor(
            @PathVariable("id") UUID id,
            @Valid @RequestBody @NotNull AuthorInfo authorInfo
        ){
        authorService.updateAuthor(
                id,
                authorInfo.address(),
                authorInfo.phoneNumber(),
                authorInfo.email());
    }
}
