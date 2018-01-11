package com.twu.biblioteca;

public class ReturnItem implements Process {
    private String returnItemInstructions() {
        return "Input the item you would like to return or Main Menu to go back";
    }

    private String invalidReturnMessage() {
        return "That is not a valid item to return";
    }

    private Boolean processBookReturn(String book, Library library) {
        library.getBookList().returnItem(book);
        library.printToConsole(library.getBookList().returnSuccessMessage());
        return true;
    }

    private Boolean processMovieReturn(String movie, Library library) {
        library.getMovieList().returnItem(movie);
        library.printToConsole(library.getMovieList().returnSuccessMessage());
        return true;
    }

    @Override
    public void run(Library library) {
        if (!library.getUser().getLoggedIn()) new Login().run(library);
        library.printToConsole(returnItemInstructions());
        Boolean returnSuccess = false;
        String input = library.getUser().getUserInput();
        while (!returnSuccess && !library.checkCommandIsQuit(input) && !library.checkCommandIsMainMenu(input)) {
            if (library.getBookList().itemCanBeReturned(input)) returnSuccess = processBookReturn(input, library);
            else if (library.getMovieList().itemCanBeReturned(input))returnSuccess = processMovieReturn(input, library);
            else {
                library.printToConsole(invalidReturnMessage());
                input = library.getUser().getUserInput();
            }
        }
        if (library.checkCommandIsQuit(input)) library.executeCommand("Quit");
        if (library.checkCommandIsMainMenu(input)) library.executeCommand("Main Menu");
    }
}
