package com.bookshop.model;

import com.bookshop.model.enums.CategoryType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    Integer availableCopies;

    @Enumerated(EnumType.STRING)
    CategoryType categoryType;

    @ManyToOne
    Author author;

    public Book() {
    }

    public Book(String name, Integer availableCopies, CategoryType categoryType, Author author) {
        this.name = name;
        this.availableCopies = availableCopies;
        this.categoryType = categoryType;
        this.author = author;
    }
}
