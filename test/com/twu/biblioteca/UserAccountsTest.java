package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserAccountsTest {
    UserAccounts tester;

    @Before
    public void setUp() {
        tester = new UserAccounts();
        Account test = new Account("nick watson", "nickwatson@gmail.com", "07807388815");
        tester.addAccount("111-2222", test);
    }

    @Test
    public void canAddAccount() {
        assertEquals(1, tester.getAccounts().size() );
    }

    @Test
    public void canGetASpecificUserAccount() {
        assertEquals(TestData.getUserInformation(), tester.getAccountByLibraryNum("111-2222").getUserInformation());
    }
}