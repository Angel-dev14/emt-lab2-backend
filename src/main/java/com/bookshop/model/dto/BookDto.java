package com.bookshop.model.dto;

import com.bookshop.model.Author;
import com.bookshop.model.enums.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {

    private Long id;

    private String name;

    private Integer availableCopies;

    private CategoryType categoryType;

    private Long authorId;
}
