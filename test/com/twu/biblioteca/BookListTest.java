package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookListTest {
    BookList tester;
    @Before
    public void setUp() throws Exception {
        tester =  new BookList();
        tester.addBook(new Book("The Hobbit", "J. R. R. Tolkien", 1937));
    }

    @Test
    public void canAddABookToListAndFormatList() {
        String s = String.format("%-25s%-25s%-25s\n", "Title", "Author", "Year");
        s += String.format("%-25s%-25s%-25s\n", "The Hobbit", "J. R. R. Tolkien", "1937" );
        assertEquals(s, tester.displayList());
    }

    @Test
    public void bookIsAvailableReturnsTrueIfBookIsInList() {
        assertTrue(tester.bookIsAvailable("the hobbit"));
    }

    @Test
    public void bookIsAvailableReturnsFalseIfBookIsNotInList() {
        assertFalse(tester.bookIsAvailable("cat in the hat"));
    }

    @Test
    public void checkoutBookSetsBooksCheckedOutPropertyToTrue() {
        assertTrue(tester.bookIsAvailable("the hobbit"));
        tester.checkoutBook("the hobbit");
        assertFalse(tester.bookIsAvailable("the hobbit"));
    }

    @Test
    public void booksThatAreCheckedOutDoNotShowOnBookList() {
        tester.checkoutBook("the hobbit");
        String s = String.format("%-25s%-25s%-25s\n", "Title", "Author", "Year");
        assertEquals(s, tester.displayList());
    }
}