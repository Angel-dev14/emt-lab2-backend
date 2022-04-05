package com.bookshop.config;

import com.bookshop.model.Country;
import com.bookshop.service.AuthorService;
import com.bookshop.service.CountryService;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final CountryService countryService;
    private final AuthorService authorService;

    public DataInitializer(CountryService countryService, AuthorService authorService) {
        this.countryService = countryService;
        this.authorService = authorService;
    }

    @PostConstruct
    public void init() {
        Country england = this.countryService.create("England", "Europe");
        Country germany = this.countryService.create("Germany", "Europe");
        //Country japan = this.countryService.create("Japan", "Asia");
        //Country china = this.countryService.create("China", "Asia");
        Country usa = this.countryService.create("United States", "North America");
        this.authorService.create("William", "Shakespeare", england);
        this.authorService.create("Johann", " Wolfgang von Goeth", germany);
        this.authorService.create("Stephen", "King", usa);
    }
}
