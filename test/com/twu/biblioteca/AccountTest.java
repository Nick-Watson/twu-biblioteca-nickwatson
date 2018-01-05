package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    Account tester;

    @Before
    public void setUp() {
        tester = TestData.getAccount();
    }

    @Test
    public void canShowUserInformation() {
        assertEquals(TestData.getUserInformation(), tester.getUserInformation());
    }

    @Test
    public void canCheckLibraryNumberAndPasswordIsCorrect() {
        assertEquals(true, tester.authenticate("111-2222", "biblio"));
    }
}