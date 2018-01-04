package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    Movie tester;
    @Before
    public void setUp() throws Exception {
        tester = new Movie("Inception", "C. Nolan", 2010, 9);
    }


    @Test
    public void getDirector() {
        assertEquals("C. Nolan", tester.getDirector());
    }

    @Test
    public void getRating() {
        assertEquals(9, tester.getRating());
    }

    @Test
    public void inheritsFromItem() {
        assertEquals("Inception", tester.getTitle());
        assertEquals(2010, tester.getYear());

    }

}