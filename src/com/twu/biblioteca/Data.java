package com.twu.biblioteca;

public class Data {
    public static BookList buildBookList() {
        BookList bL = new BookList();
        bL.addBook(new Book("Lord Of The Rings", "J.R.R Tolkien", 1945));
        bL.addBook(new Book("Cat in the Hat", "Dr Seuss", 1941));
        bL.addBook(new Book("Harry Potter", "J.K Rowling", 1999));

        return bL;
    }
}
