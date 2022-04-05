package com.bookshop.service.impl;

import com.bookshop.model.Author;
import com.bookshop.model.Country;
import com.bookshop.model.exceptions.AuthorNotFoundException;
import com.bookshop.repository.AuthorRepository;
import com.bookshop.service.AuthorService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Author findById(Long authorId) {
        return repository.findById(authorId).orElseThrow(() -> new AuthorNotFoundException(authorId));
    }

    @Override
    public List<Author> findAll() {
        return repository.findAll();
    }

    @Override
    public void create(String name, String surname, Country country) {
        Author author = new Author(name, surname, country);
        this.repository.save(author);
    }
}
