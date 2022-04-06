package com.bookshop.web;

import com.bookshop.model.Book;
import com.bookshop.model.dto.BookDto;
import com.bookshop.service.BookService;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://emt-lab2-library-frontend.herokuapp.com", exposedHeaders = "total-elements")
@RestController
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService service;

    public BookRestController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/paginated")
    public ResponseEntity<List<Book>> findAllPageable(Pageable pageable) {
        Page<Book> pages = service.findAll(pageable);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("total-elements", String.valueOf(pages.getTotalElements()));
        return ResponseEntity.ok().headers(responseHeaders).body(pages.getContent());
    }

    @GetMapping("{bookId}")
    public ResponseEntity<Book> findById(@PathVariable Long bookId) {
        return ResponseEntity.ok().body(service.findById(bookId));
    }

    @PostMapping("/create-or-update")
    public ResponseEntity<Book> createOrUpdateBook(@RequestBody BookDto bookDto) {
        Book book = this.service.createOrUpdate(
            bookDto.getId(),
            bookDto.getName(),
            bookDto.getAvailableCopies(),
            bookDto.getCategoryType(),
            bookDto.getAuthorId()
        );
        return ResponseEntity.ok().body(book);
    }

    @PutMapping("/mark-as-taken/{bookId}")
    public ResponseEntity<Void> markAsTaken(@PathVariable Long bookId) {
        service.markAsTaken(bookId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        service.deleteById(bookId);
        return ResponseEntity.ok().build();
    }
}
