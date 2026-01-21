package com.docencia.aed.controller;

import com.docencia.aed.entity.Publisher;
import com.docencia.aed.service.IPublisherService;
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
public class PublisherController {

    private final IPublisherService service;

    public PublisherController(IPublisherService service) {
        this.service = service;
    }

    @Operation(summary = "Get all publishers")
    @GetMapping("/publishers")
    public List<Publisher> getAllPublishers() {
        return service.findAll();
    }

    @Operation(summary = "Create publisher")
    @PostMapping("/publishers")
    public ResponseEntity<Publisher> createPublisher(@Valid @RequestBody Publisher publisher) {
        Publisher created = service.create(publisher);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}
