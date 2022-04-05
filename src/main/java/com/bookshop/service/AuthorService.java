package com.bookshop.service;

import com.bookshop.model.Author;
import com.bookshop.model.Country;
import java.util.List;

public interface AuthorService {

    Author findById(Long authorId);

    List<Author> findAll();

    void create(String name, String surname, Country country);
}
