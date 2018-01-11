package com.twu.biblioteca;

public class ListMovies implements Process{
    @Override
    public void run(Library library) {
        library.printToConsole(library.getMovieList().displayList());
    }
}
