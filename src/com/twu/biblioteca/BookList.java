package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> availableBooks = new ArrayList<Book>();

    public void addBook(Book b) {
        this.availableBooks.add(b);
    }

    private ArrayList<Book> getAvailableBooks() {
        return this.availableBooks;
    }

    private String headerToString() {
        return String.format("%-25s%-25s%-25s\n","Title","Author","Year");
    }

    private String booksToString() {
        StringBuilder s = new StringBuilder();

        for (Book b : getAvailableBooks()) {
            s.append(String.format("%-25s%-25s%-25s\n",b.getTitle(),b.getAuthor(),b.getYear()));
        }
        return s.toString();
    }

    public String listToString() {
        return headerToString() + booksToString();
    }
}
