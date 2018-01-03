package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {
    Library tester;

    @Before
    public void setUp() throws Exception {
        tester = new Library("Bangalore Public Library");
        tester.setBookList(Data.buildBookList());
    }

    @Test
    public void createWelcomeMessage() {
        assertEquals("Welcome to the Bangalore Public Library", tester.createWelcomeMessage());
    }

    @Test
    public void checkoutBookReturnsCorrectResponseOnSuccessfulCheckout() {
        assertEquals("Thank you! Enjoy the book", tester.checkoutBook("lord of the rings"));
        assertEquals("That book is not available", tester.checkoutBook("the hobbit"));
    }

    @Test
    public void returnBookReturnsCorrectResponseOnSuccessfulCheckout() {
        tester.getBookList().checkoutBook("lord of the rings");
        assertEquals("Thank you for returning the book", tester.returnBook("lord of the rings"));
        assertEquals("That is not a valid book to return", tester.returnBook("the hobbit"));
    }

}