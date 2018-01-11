package com.twu.biblioteca;

public class UserDetails implements Process {
    @Override
    public void run(Library library) {
        library.printToConsole(library.getUser().getUserInformation());
    }
}
