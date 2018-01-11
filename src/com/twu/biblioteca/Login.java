package com.twu.biblioteca;

public class Login implements Process{
    @Override
    public void run(Library library) {
        while (!library.getUser().getLoggedIn()) {
            library.printToConsole("Please input library number");
            String libraryNumber = library.getUser().getUserInput();
            library.printToConsole("Please input password");
            String password = library.getUser().getUserInput();

            if (library.getUserAccounts().authenticate(libraryNumber, password)) {
                library.getUser().setLoggedIn(true);
                library.getUser().setAccount(library.getUserAccounts().getAccountByLibraryNum(libraryNumber));
                library.printToConsole("login success");
            } else library.printToConsole("login fail, try again");
        }
    }
}
