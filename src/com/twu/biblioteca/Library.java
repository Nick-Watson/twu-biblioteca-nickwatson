package com.twu.biblioteca;

public class Library {
    private String name;
    private BookList bookList;

    Library (String name) {
        this.name = name;
    }

    Library (String name, BookList bookList) {
        this.name = name;
        this.bookList = bookList;
    }

    private String getLibraryName() {
        return this.name;
    }

    private BookList getBookList() {
        return  this.bookList;
    }

    public void setBookList(BookList bookList) {
        this.bookList = bookList;
    }

    public String createWelcomeMessage(){
        return "Welcome to the " + getLibraryName();
    }

    private void displayWelcomeMessage() {
        System.out.println(createWelcomeMessage());
    }

    private void displayBookList() {
        System.out.println(getBookList().listToString());
    }

    public void run() {
        displayWelcomeMessage();
        displayBookList();
    }
}
