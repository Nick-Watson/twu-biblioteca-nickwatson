package com.twu.biblioteca;

public class Data {
    public static BookList buildBookList() {
        BookList bL = new BookList();
        bL.addItem(new Book("Lord Of The Rings", "J.R.R Tolkien", 1945));
        bL.addItem(new Book("Cat in the Hat", "Dr Seuss", 1941));
        bL.addItem(new Book("Harry Potter", "J.K Rowling", 1999));

        return bL;
    }
}
