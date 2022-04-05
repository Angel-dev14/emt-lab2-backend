package com.bookshop.web;

import com.bookshop.model.Country;
import com.bookshop.service.CountryService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/countries")
public class CountryRestController {

    private final CountryService service;

    public CountryRestController(CountryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Country>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }
}
