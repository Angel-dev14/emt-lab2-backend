package com.bookshop.model.exceptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long bookId) {
        super(String.format("Book with id %d was not found", bookId));
    }
}
