package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    Book tester;
    @Before
    public void setUp() throws Exception {
        tester = new Book("The Hobbit", "J. R. R. Tolkien", 1937);
    }

    @Test
    public void getAuthor() {
        assertEquals("J. R. R. Tolkien", tester.getAuthor());
    }

    @Test
    public void inheritsFromItem() {
        assertEquals("The Hobbit", tester.getTitle());
        assertEquals(1937, tester.getYear());
    }
}