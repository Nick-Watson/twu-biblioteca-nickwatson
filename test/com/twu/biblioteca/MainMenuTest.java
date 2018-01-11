package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

    @Test
    public void run() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        tester.run(TestData.getTestLibrary());
        assertEquals(TestData.getMenuDisplayNoLogin() + "\n", outContent.toString());
    }
}