package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {
    Library tester;

    @Before
    public void setUp() throws Exception {
        tester = new Library("Bangalore Public Library");
    }

    @Test
    public void createWelcomeMessage() {
        assertEquals("Welcome to the Bangalore Public Library", tester.createWelcomeMessage());
    }

}