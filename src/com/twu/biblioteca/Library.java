package com.twu.biblioteca;

public class Library {
    private String name;
    private MainMenu mainMenu = new MainMenu();
    private BookList bookList = null;
    private User user = null;

    Library (String name) {
        this.name = name;
    }

    private String getLibraryName() {
        return this.name;
    }

    public void setUser(User usr) {
        this.user = usr;
    }

    private User getUser() {
        return this.user;
    }

    public BookList getBookList() {
        return this.bookList;
    }

    public void setBookList(BookList bookList) {
        this.bookList = bookList;
    }

    private MainMenu getMainMenu(){
        return this.mainMenu;
    }

    public String createWelcomeMessage(){
        return "Welcome to the " + getLibraryName();
    }

    private void printToConsole(String s) {
        System.out.println(s);
    }

    private void displayWelcomeMessage() {
        printToConsole(createWelcomeMessage());
    }

    private void displayMainMenu() {
        printToConsole(getMainMenu().displayOptions());
    }

    private void processListBooks() {
        printToConsole(getBookList().displayList());
    }

    public String checkoutBook (String book) {
        if (getBookList().bookIsAvailable(book)) {
            getBookList().checkoutBook(book);
            return "Thank you! Enjoy the book";
        }
        return "That book is not available";
    }

    public String returnBook (String book) {
        if (getBookList().bookCanBeReturned(book)) {
            getBookList().returnBook(book);
            return "Thank you for returning the book";
        }
        return "That is not a valid book to return";
    }

    private Boolean checkCommandIsQuit (String input) {
        return input.equals("quit");
    }

    private Boolean checkCommandIsMainMenu (String input) {
        return input.equals("main menu");
    }

    private void processCheckoutBook() {
        printToConsole("Input the book you would like to checkout or main menu to go back");
        Boolean checkoutSuccess = false;
        String input = getUser().getUserInput();
        while (!checkoutSuccess && !checkCommandIsQuit(input) && !checkCommandIsMainMenu(input)) {
            if (getBookList().bookIsAvailable(input)) {
                printToConsole(checkoutBook(input));
                checkoutSuccess = true;
            }
            else {
                printToConsole(checkoutBook(input));
                input = getUser().getUserInput();
            }
        }
    }

    private void processReturnBook() {
        printToConsole("Input the book you would like to return or main menu to go back");
        Boolean returnSuccess = false;
        String input = getUser().getUserInput();
        while (!returnSuccess && !checkCommandIsQuit(input) && !checkCommandIsMainMenu(input)) {
            if (getBookList().bookCanBeReturned(input)) {
                printToConsole(returnBook(input));
                returnSuccess = true;
            }
            else {
                printToConsole(returnBook(input));
                input = getUser().getUserInput();
            }
        }
    }

    private void processQuit() {
        printToConsole("Goodbye");
        System.exit(0);
    }

    private void processInvalidOption() {
        printToConsole("Select a valid option!");
    }

    private void processCommand(String command) {
        if (command.equals("quit")) processQuit();
        else if (command.equals("list books")) processListBooks();
        else if (command.equals("checkout book")) processCheckoutBook();
        else if (command.equals("return book")) processReturnBook();
        else processInvalidOption();
    }

    public void run() {
        displayWelcomeMessage();
        displayMainMenu();
        while (true) {
            if (checkCommandIsQuit(getUser().getUserChoice())) processQuit();
            if (checkCommandIsMainMenu(getUser().getUserChoice())) displayMainMenu();
            processCommand(getUser().getUserInput());
        }
    }
}
