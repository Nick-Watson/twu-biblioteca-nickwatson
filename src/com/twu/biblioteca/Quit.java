package com.twu.biblioteca;

public class Quit implements Process{
    @Override
    public void run(Library library) {
        library.printToConsole("Goodbye");
        System.exit(0);
    }
}
