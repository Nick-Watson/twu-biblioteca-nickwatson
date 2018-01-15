package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class LoginTest {
    Login tester;

    @Before
    public void setUp() throws Exception {
        tester = new Login();

    }

    @Test
    public void getUserLibraryNumber() {
        InputStream in = new ByteArrayInputStream("111-2222".getBytes());
        System.setIn(in);
        assertEquals("111-2222", tester.getUserLibraryNumber(new User()));
    }

    @Test
    public void getUserPassword() {
        InputStream in = new ByteArrayInputStream("biblio".getBytes());
        System.setIn(in);
        assertEquals("biblio", tester.getUserPassword(new User()));
    }

    @Test
    public void authenticateWithCorrectDetails() {
        assertTrue(tester.authenticate("111-2222", "biblio", Data.buildUserAccounts()));
    }

    @Test
    public void authenticateWithIncorrectDetails() {
        assertFalse(tester.authenticate("111-222", "bibliot", Data.buildUserAccounts()));
    }

    @Test
    public void updatesUserLoginAndAccount() {
        User testUser = new User();
        tester.updateUserLoginAndAccount(testUser, new Account("111-2222", "biblio","nick watson", "nickwatson@gmail.com", "07807388815"));
        assertTrue(testUser.getLoggedIn());
        assertEquals(Account.class, testUser.getAccount().getClass());
    }

    @Test
    public void processASuccessfullLogin() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        User testUser = new User();
        tester.processLogin(true, testUser, new Account("111-2222", "biblio","nick watson", "nickwatson@gmail.com", "07807388815"));
        assertEquals("login success\n", outContent.toString());
        assertTrue(testUser.getLoggedIn());
    }

    @Test
    public void processAUnsuccessfullLogin() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        User testUser = new User();
        tester.processLogin(false, testUser, new Account("111-2222", "biblio","nick watson", "nickwatson@gmail.com", "07807388815"));
        assertEquals("login fail, try again\n", outContent.toString());
        assertFalse(testUser.getLoggedIn());
    }

    @Test
    public void runSuccessfulLogin() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String data = "111-2222\nbiblio";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Scanner scanner = new Scanner(System.in);
        tester.run(TestData.getTestLibrary());
        assertEquals("Please input library number\n" +
                "Please input password\n" +
                "login success\n", outContent.toString());
    }
}