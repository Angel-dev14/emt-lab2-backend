package com.bookshop.web;

import com.bookshop.model.enums.CategoryType;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://emt-lab2-library-frontend.herokuapp.com")
@RestController
@RequestMapping("/api/categories")
public class CategoriesRestController {

    @GetMapping
    public ResponseEntity<List<CategoryType>> findAll() {
        return ResponseEntity.ok().body(List.of(CategoryType.values()));
    }
}
