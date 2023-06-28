package com.sbertech.book;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BookTest {

    static Book book;

    @BeforeAll
    static void beforeAll() {
        book = new Book(
                "Harry Potter",
                new Author("J. K. Rowling", Gender.FEMALE, "unknown"),
                2005);
    }

    @Test
    void getName() {
        System.out.println(book.getName());
    }

    @Test
    void getAuthor() {
        System.out.println(book.getAuthor().toString());
    }

    @Test
    void getYear() {
        System.out.println(book.getYear());
    }

    @Test
    void testToString() {
        System.out.println(book.toString());
    }
}