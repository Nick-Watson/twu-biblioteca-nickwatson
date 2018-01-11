package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class LibraryTest {
    Library tester;
    ByteArrayOutputStream outContent;

    @Before
    public void setUp() throws Exception {
        tester = TestData.getTestLibrary();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void printToConsole() {
        tester.printToConsole("hello");
        assertEquals("hello\n", outContent.toString());

    }

    @Test
    public void createWelcomeMessage() {
        assertEquals("Welcome to the Bangalore Public Library", tester.createWelcomeMessage());
    }

    @Test
    public void checkCommandIsQuit() {
        assertTrue(tester.checkCommandIsQuit("quit"));
    }

    @Test
    public void checkCommandIsMainMenu() {
        assertTrue(tester.checkCommandIsMainMenu("main menu"));
    }

    @Test
    public void executeCommand() {
        tester.executeCommand("Main Menu");
        assertEquals(TestData.getMenuDisplayNoLogin() + "\n", outContent.toString());
    }

}