package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library BPL = new Library("Bangalore Public Library");
        BPL.setBookList(Data.buildBookList());
        BPL.setMovieList(Data.buildMovieList());
        BPL.setUser(new User());
        BPL.run();
    }
}
