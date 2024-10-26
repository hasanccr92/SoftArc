package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    private Library library;
    private Book book1;
    private Book book2;
    private Book book3;

    @BeforeEach
    void setUp() {
        library = new Library();
        book1 = new Book("Title1", "Author1", 2020);
        book2 = new Book("Title2", "Author1", 2021);
        book3 = new Book("Title3", "Author2", 2020);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
    }

    @Test
    void testAddBook() {
        Book book4 = new Book("Title4", "Author3", 2022);
        library.addBook(book4);
        assertTrue(library.getAllBooks().contains(book4), "The library should contain the newly added book");
    }

    @Test
    void testRemoveBook() {
        library.removeBook(book1);
        assertFalse(library.getAllBooks().contains(book1), "The library should not contain the removed book");
    }

    @Test
    void testGetBooksByAuthor() {
        List<Book> booksByAuthor1 = library.getBooksByAuthor("Author1");
        assertEquals(2, booksByAuthor1.size(), "There should be 2 books by Author1");
        assertTrue(booksByAuthor1.contains(book1) && booksByAuthor1.contains(book2), "Books by Author1 should be returned");
    }

    @Test
    void testGetBooksByYear() {
        List<Book> books2020 = library.getBooksByYear(2020);
        assertEquals(2, books2020.size(), "There should be 2 books published in 2020");
        assertTrue(books2020.contains(book1) && books2020.contains(book3), "Books from the year 2020 should be returned");
    }
}
