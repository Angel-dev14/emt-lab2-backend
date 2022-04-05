package com.bookshop.service;

import com.bookshop.model.Country;
import java.util.List;

public interface CountryService {

    Country findById(Long countryId);

    List<Country> findAll();

    Country create(String name, String continent);
}
