package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ItemListTest {
    ItemList tester;
    @Before
    public void setUp() throws Exception {
        tester = new ItemList();
        tester.addItem(new Item ("Inception", 2010));
    }

    @Test
    public void getAvailableItems() {
        assertEquals(ArrayList.class, tester.getAvailableItems().getClass());
    }

    @Test
    public void addItem() {
        assertEquals(1, tester.getAvailableItems().size());
    }

    @Test
    public void itemIsAvailable() {
        assertTrue(tester.itemIsAvailable("Inception"));
        assertFalse(tester.itemIsAvailable("Star Wars"));
    }

    @Test
    public void checkoutItem() {
        assertTrue(tester.itemIsAvailable("Inception"));
        tester.checkoutItem("Inception", "111-2222");
        assertFalse(tester.itemIsAvailable("Inception"));
    }

    @Test
    public void itemCanBeReturned() {
        tester.checkoutItem("Inception", "111-2222");
        assertTrue(tester.itemCanBeReturned("Inception"));
    }

    @Test
    public void returnItem() {
        tester.checkoutItem("Inception", "111-2222");
        assertFalse(tester.itemIsAvailable("Inception"));
        tester.returnItem("Inception");
        assertTrue(tester.itemIsAvailable("Inception"));
    }
}