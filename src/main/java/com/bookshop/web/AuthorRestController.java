package com.bookshop.web;

import com.bookshop.model.Author;
import com.bookshop.service.AuthorService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://emt-lab2-library-frontend.herokuapp.com")
@RestController
@RequestMapping("/api/authors")
public class AuthorRestController {

    private final AuthorService service;

    public AuthorRestController(AuthorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Author>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
}
