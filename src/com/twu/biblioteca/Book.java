package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private int year;
    private Boolean isCheckedOut;

    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isCheckedOut = false;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getYear() {
        return this.year;
    }

    public Boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setIsCheckedOut(Boolean bool) {
        this.isCheckedOut = bool;
    }
}
