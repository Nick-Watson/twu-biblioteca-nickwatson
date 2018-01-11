package com.twu.biblioteca;

public class InvalidOption implements Process {
    @Override
    public void run(Library library) {
        library.printToConsole("Select a valid option!");
    }
}
