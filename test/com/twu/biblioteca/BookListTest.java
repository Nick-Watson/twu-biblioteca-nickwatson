package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookListTest {
    BookList tester;
    @Before
    public void setUp() {
        tester =  new BookList();
        tester.addItem(new Book("The Hobbit", "J. R. R. Tolkien", 1937));
    }

    @Test
    public void displayList() {
        String s = String.format("%-25s%-25s%-25s\n", "Title", "Author", "Year");
        s += String.format("%-25s%-25s%-25s\n", "The Hobbit", "J. R. R. Tolkien", "1937" );
        assertEquals(s, tester.displayList());
    }

    @Test
    public void booksThatAreCheckedOutDoNotShowOnBookList() {
        tester.checkoutItem("the hobbit", "111-2222");
        String s = String.format("%-25s%-25s%-25s\n", "Title", "Author", "Year");
        assertEquals(s, tester.displayList());
    }
}