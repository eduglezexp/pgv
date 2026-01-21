package com.docencia.aed.controller;

import com.docencia.aed.entity.Book;
import com.docencia.aed.service.IBookService;
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
@Tag(name = "Metodos de los books")
public class BookController {

    private final IBookService service;

    public BookController(IBookService service) {
        this.service = service;
    }

    @Operation(summary = "Get all books")
    @GetMapping("/books")
    public List<Book> getAllBooks(@RequestParam(value = "authorId", required = false) Long authorId) {
        return service.findAll(authorId);
    }

    @Operation(summary = "Get book by ID")
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id) {
        return service.findById(id);
    }

    @Operation(summary = "Create a book for an author")
    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestParam("authorId") Long authorId,
            @Valid @RequestBody Book book) {
        Book created = service.create(authorId, book);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
