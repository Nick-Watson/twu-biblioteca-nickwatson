package com.twu.biblioteca;

public class TestData {
    public static String getBookListData() {
        StringBuilder s = new StringBuilder();
        s.append(String.format("%-25s%-25s%-25s\n","Title","Author","Year"));
        s.append(String.format("%-25s%-25s%-25s\n", "Lord Of The Rings", "J.R.R Tolkien", "1945" ));
        s.append(String.format("%-25s%-25s%-25s\n", "Cat in the Hat", "Dr Seuss", "1941" ));
        s.append(String.format("%-25s%-25s%-25s\n", "Harry Potter", "J.K Rowling", "1999" ));
        return s.toString();
    }
}
