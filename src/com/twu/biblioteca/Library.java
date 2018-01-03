package com.twu.biblioteca;

public class Library {
    private String name;
    private MainMenu mainMenu = new MainMenu();
    private BookList bookList = null;
    private User user = null;

    Library (String name) {
        this.name = name;
    }

    Library (String name, BookList bookList) {
        this.name = name;
        setBookList(bookList);
    }

    private String getLibraryName() {
        return this.name;
    }

    public void setUser(User usr) {
        this.user = usr;
    }

    public User getUser() {
        return this.user;
    }

    private BookList getBookList() {
        return  this.bookList;
    }

    public void setBookList(BookList bookList) {
        this.bookList = bookList;
    }

    public String createWelcomeMessage(){
        return "Welcome to the " + getLibraryName();
    }

    public void printToConsole(String s) {
        System.out.println(s);
    }

    private void displayWelcomeMessage() {
        printToConsole(createWelcomeMessage());
    }

    private void displayMainMenu() {
        printToConsole(mainMenu.displayOptions());
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

    private void processCheckoutBook() {
        printToConsole("Which book would like to checkout?");
        Boolean checkoutSuccess = false;
        String s = getUser().getUserInput();
        while (!checkoutSuccess && !s.equals("quit")) {
            if (getBookList().bookIsAvailable(s)) {
                printToConsole(checkoutBook(s));
                checkoutSuccess = true;
            }
            else {
                printToConsole(checkoutBook(s));
                s = getUser().getUserInput();
            }
        }
    }

    private void processQuit() {
        printToConsole("Goodbye");
    }

    private void processInvalidOption() {
        printToConsole("Select a valid option!");
    }

    public void processCommand(String command) {
        if (command.equals("quit")) processQuit();
        else if (command.equals("list books")) processListBooks();
        else if (command.equals("checkout book")) processCheckoutBook();
        else processInvalidOption();
    }

    public void run() {
        displayWelcomeMessage();
        displayMainMenu();
        while (!getUser().getUserChoice().equals("quit")) {
            processCommand(getUser().getUserInput());
        }
    }
}