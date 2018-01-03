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
            if (!b.isCheckedOut()) s.append(String.format("%-25s%-25s%-25s\n",b.getTitle(),b.getAuthor(),b.getYear()));
        }
        return s.toString();
    }

    public String displayList() {
        return headerToString() + booksToString();
    }

    public Boolean bookIsAvailable(String book) {
        for (Book b : getAvailableBooks()) {
            if (b.getTitle().toLowerCase().equals(book) && !b.isCheckedOut()) {
                return true;
            }
        }
        return false;
    }

    public void checkoutBook(String book) {
        for (Book b : getAvailableBooks()) {
            if (b.getTitle().toLowerCase().equals(book.toLowerCase())) {
                b.setIsCheckedOut(true);
            }
        }
    }
}
