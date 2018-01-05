package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainMenuTest {
    MainMenu tester;
    @Before
    public void setUp() throws Exception {
        tester = new MainMenu();
    }

    @Test
    public void displayOptionsNoLogin() {
        assertEquals(TestData.getMenuDisplayNoLogin(), tester.displayOptions(false));
    }

    @Test
    public void displayOptionsLoggedIn() {
        assertEquals(TestData.getMenuDisplayLoggedIn(), tester.displayOptions(true));
    }
}