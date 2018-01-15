package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Library BPL = new Library("Bangalore Public Library");
        BPL.setBookList(Data.buildBookList());
        BPL.setMovieList(Data.buildMovieList());
        BPL.setUserAccounts(Data.buildUserAccounts());
        BPL.setUser(new User());
        BPL.start();
    }
}
