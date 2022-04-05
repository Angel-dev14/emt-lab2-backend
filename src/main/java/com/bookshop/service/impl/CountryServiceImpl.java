package com.bookshop.service.impl;

import com.bookshop.model.Country;
import com.bookshop.model.exceptions.AuthorNotFoundException;
import com.bookshop.repository.CountryRepository;
import com.bookshop.service.CountryService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository repository;

    public CountryServiceImpl(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Country findById(Long countryId) throws AuthorNotFoundException {
        return repository.findById(countryId).orElseThrow(() -> new AuthorNotFoundException(countryId));
    }

    @Override
    public List<Country> findAll() {
        return repository.findAll();
    }

    public Country create(String name, String continent) {
        Country country = new Country(name, continent);
        return this.repository.save(country);
    }
}
