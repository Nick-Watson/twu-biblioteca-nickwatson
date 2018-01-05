package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserAccountsTest {
    UserAccounts tester;

    @Before
    public void setUp() {
        tester = new UserAccounts();
        tester.addAccount("111-2222", TestData.getAccount());
    }

    @Test
    public void canAddAccount() {
        assertEquals(1, tester.getAccounts().size() );
    }

    @Test
    public void canGetASpecificUserAccount() {
        assertEquals(TestData.getUserInformation(), tester.getAccountByLibraryNum("111-2222").getUserInformation());
    }

    @Test
    public void canAuthenticateALogin() {
        assertTrue(tester.authenticate("111-2222", "biblio"));
    }
}