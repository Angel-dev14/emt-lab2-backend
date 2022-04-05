package com.bookshop.model.exceptions;

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException(Long authorId) {
        super(String.format("Author with id %d was not found", authorId));
    }
}
