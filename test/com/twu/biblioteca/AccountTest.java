package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    Account tester;

    @Before
    public void setUp() {
        tester = new Account("nick watson", "nickwatson@gmail.com", "07807388815");
    }

    @Test
    public void canShowUserInformation() {
        assertEquals(TestData.getUserInformation(), tester.getUserInformation());
    }
}