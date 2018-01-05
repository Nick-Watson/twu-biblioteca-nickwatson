package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieListTest {
    MovieList tester;
    @Before
    public void setUp() {
        tester = new MovieList();
        tester.addItem(new Movie("Inception", "C. Nolan", 2010, 9));
    }

    @Test
    public void displayList() {
        String s = String.format("%-25s%-25s%-25s%-25s\n", "Title", "Director", "Year", "Rating");
        s += String.format("%-25s%-25s%-25s%-25s\n", "Inception", "C. Nolan", "2010", "9" );
        assertEquals(s, tester.displayList());
    }

    @Test
    public void MoviesThatAreCheckedOutDoNotShowOnBookList() {
        tester.checkoutItem("Inception", "111-2222");
        String s = String.format("%-25s%-25s%-25s%-25s\n", "Title", "Director", "Year", "Rating");
        assertEquals(s, tester.displayList());
    }
}