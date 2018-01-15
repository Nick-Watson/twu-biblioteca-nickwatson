package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getUserInput() {
        InputStream in = new ByteArrayInputStream("List Books".getBytes());
        System.setIn(in);
        User customer = new User();
        assertEquals("List Books", customer.getUserInput());
    }
}