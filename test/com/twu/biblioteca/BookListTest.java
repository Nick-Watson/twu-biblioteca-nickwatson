package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookListTest {
    BookList tester;
    @Before
    public void setUp() throws Exception {
        tester =  new BookList();
    }

    @Test
    public void canAddABookToListAndFormatList() {
        tester.addBook(new Book("The Hobbit", "J. R. R. Tolkien", 1937));
        String s = String.format("%-25s%-25s%-25s\n", "Title", "Author", "Year");
        s += String.format("%-25s%-25s%-25s\n", "The Hobbit", "J. R. R. Tolkien", "1937" );
        assertEquals(s, tester.listToString());
    }
}