package com.twu.biblioteca;

public class Data {
    public static BookList buildBookList() {
        BookList bL = new BookList();
        bL.addItem(new Book("Lord Of The Rings", "J.R.R Tolkien", 1945));
        bL.addItem(new Book("Cat in the Hat", "Dr Seuss", 1941));
        bL.addItem(new Book("Harry Potter", "J.K Rowling", 1999));

        return bL;
    }

    public static MovieList buildMovieList() {
        MovieList mL = new MovieList();
        mL.addItem(new Movie("Inception", "C. Nolan", 2010, 9));
        mL.addItem(new Movie("Dunkirk", "C. Nolan", 2017, 8));
        mL.addItem(new Movie("Logan", "James Mangold", 2017, 8));

        return mL;
    }

    public static UserAccounts buildUserAccounts() {
        UserAccounts uA = new UserAccounts();
        uA.addAccount("111-2222", new Account("nick watson", "nickwatson@gmail.com", "07807388815"));
        return uA;
    }
}
