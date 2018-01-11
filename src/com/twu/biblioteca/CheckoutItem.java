package com.twu.biblioteca;

public class CheckoutItem implements Process{

    private String checkoutItemInstructions() {
        return "Input the item you would like to checkout or main menu to go back";
    }

    private String invalidCheckoutMessage() {
        return "That item is not available";
    }

    private Boolean processBookCheckout (String book, Library library) {
        library.getBookList().checkoutItem(book, library.getUser().getUserLibraryNumber());
        library.printToConsole(library.getBookList().checkoutSuccessMessage());
        return true;
    }

    private Boolean processMovieCheckout (String movie, Library library) {
        library.getMovieList().checkoutItem(movie, library.getUser().getUserLibraryNumber());
        library.printToConsole(library.getMovieList().checkoutSuccessMessage());
        return true;
    }

    @Override
    public void run(Library library) {
        if (!library.getUser().getLoggedIn()) library.executeCommand("Login");
        library.printToConsole(checkoutItemInstructions());
        Boolean checkoutSuccess = false;
        String input = library.getUser().getUserInput();
        while (!checkoutSuccess && !library.checkCommandIsQuit(input) && !library.checkCommandIsMainMenu(input)) {
            if (library.getBookList().itemIsAvailable(input)) checkoutSuccess = processBookCheckout(input, library);
            else if (library.getMovieList().itemIsAvailable(input)) checkoutSuccess = processMovieCheckout(input, library);
            else {
                library.printToConsole(invalidCheckoutMessage());
                input = library.getUser().getUserInput();
            }
        }
        if (library.checkCommandIsQuit(input)) library.executeCommand("Quit");
        if (library.checkCommandIsMainMenu(input)) library.executeCommand("Main Menu");
    }
}
