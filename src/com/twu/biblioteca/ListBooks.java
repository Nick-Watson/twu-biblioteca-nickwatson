package com.twu.biblioteca;

public class ListBooks implements Process {
    @Override
    public void run(Library library) {
        library.printToConsole(library.getBookList().displayList());
    }
}
