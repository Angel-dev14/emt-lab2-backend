package com.bookshop.service;

import com.bookshop.model.Book;
import com.bookshop.model.enums.CategoryType;
import com.bookshop.model.exceptions.BookNotFoundException;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    Book findById(Long bookId) throws BookNotFoundException;

    List<Book> findAll();

    Page<Book> findAll(Pageable pageable);

    Book createOrUpdate(Long id, String name, Integer availableCopies, CategoryType categoryType, Long authorId);

    Book deleteById(Long bookId);

    void markAsTaken(Long bookId);
}
