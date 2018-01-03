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
    public void displayOptions() {
        String s  = "Main Menu\n\n-List Books\n-Checkout Book\n\nPlease select an option or type quit to exit\n";
        assertEquals(s, tester.displayOptions());
    }
}