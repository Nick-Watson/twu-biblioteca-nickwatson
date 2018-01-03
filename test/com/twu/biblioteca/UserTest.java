package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getUserInput() {
        User customer = new User();
        String input = "List Books";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("list books", customer.getUserInput());
    }
}