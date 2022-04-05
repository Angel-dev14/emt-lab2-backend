package com.bookshop.service.impl;

import com.bookshop.model.Author;
import com.bookshop.model.Book;
import com.bookshop.model.enums.CategoryType;
import com.bookshop.model.exceptions.BookNoLongerAvailableException;
import com.bookshop.model.exceptions.BookNotFoundException;
import com.bookshop.repository.BookRepository;
import com.bookshop.service.AuthorService;
import com.bookshop.service.BookService;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository repository, AuthorService authorService) {
        this.repository = repository;
        this.authorService = authorService;
    }

    @Override
    public Book findById(Long bookId) throws BookNotFoundException {
        return repository.findById(bookId).orElseThrow(() -> new BookNotFoundException(bookId));
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Book createOrUpdate(Long id, String name, Integer availableCopies, CategoryType categoryType,
                               Long authorId) {
        if (id == null) {
            return create(name, availableCopies, categoryType, authorId);
        } else {
            return update(id, name, availableCopies, categoryType, authorId);
        }
    }

    private Book create(String name, Integer availableCopies, CategoryType categoryType, Long authorId) {
        Author author = authorService.findById(authorId);
        Book book = new Book(name, availableCopies, categoryType, author);
        return repository.save(book);
    }

    private Book update(Long id, String name, Integer availableCopies, CategoryType categoryType, Long authorId) {
        Book book = findById(id);
        Author author = authorService.findById(authorId);
        book.setName(name);
        book.setAvailableCopies(availableCopies);
        book.setCategoryType(categoryType);
        book.setAuthor(author);
        return repository.save(book);
    }

    @Override
    public Book deleteById(Long bookId) {
        Book book = repository.getById(bookId);
        repository.delete(book);
        return book;
    }

    @Override
    public void markAsTaken(Long bookId) throws BookNoLongerAvailableException {
        Book book = findById(bookId);
        Integer availableCopies = book.getAvailableCopies();
        if (availableCopies == 0) {
            throw new BookNoLongerAvailableException(book.getName());
        }
        book.setAvailableCopies(availableCopies - 1);
        repository.save(book);
    }
}
