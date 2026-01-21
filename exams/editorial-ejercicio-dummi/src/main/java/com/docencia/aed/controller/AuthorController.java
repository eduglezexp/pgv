package com.docencia.aed.controller;

import com.docencia.aed.entity.Author;
import com.docencia.aed.entity.Book;
import com.docencia.aed.service.IAuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author eduglezexp
 * @version 1.0.0
 */

@RestController
@RequestMapping
@CrossOrigin
@Tag(name = "Metodos de los Authors")
public class AuthorController {

    private final IAuthorService service;

    public AuthorController(IAuthorService service) {
        this.service = service;
    }

    @Operation(summary = "Get all authors")
    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = service.findAll();
        if (authors.isEmpty() || authors == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(authors);
        }
        return ResponseEntity.status(HttpStatus.OK).body(authors);
    }

    @Operation(summary = "Get author by id")
    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        Author author = service.findById(id);
        if (author.getId() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(author);
        }
        return ResponseEntity.status(HttpStatus.OK).body(author);
    }

    @Operation(summary = "Create a author")
    @PostMapping("/authors")
    public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author author) {
        Author created = service.create(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(summary = "Get a book by author")
    @GetMapping("/authors/{id}/books")
    public List<Book> getBooksByAuthor(@PathVariable("id") Long authorId) {
        return service.findBooksByAuthor(authorId);
    }
}
