package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    Item tester;
    @Before
    public void setUp(){
        tester = new Item("Star Wars", 2017);
    }

    @Test
    public void getTitle() {
        assertEquals("Star Wars", tester.getTitle());
    }

    @Test
    public void getYear() {
        assertEquals(2017, tester.getYear());
    }

    @Test
    public void isCheckedOut() {
        assertFalse(tester.isCheckedOut());
    }

    @Test
    public void canCheckOutItem() {
        tester.checkoutItem("111-2222");
        assertTrue(tester.isCheckedOut());
        assertEquals("111-2222", tester.getCheckedOutBy());
    }
}