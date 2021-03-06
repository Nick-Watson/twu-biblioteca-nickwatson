package com.twu.biblioteca;

public class Library {
    private String name;
    private UserAccounts userAccounts = null;
    private BookList bookList = null;
    private MovieList movieList = null;
    private User user = null;

    Library(){}

    Library (String name) {
        this.name = name;
    }

    private String getLibraryName() {
        return this.name;
    }

    public UserAccounts getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(UserAccounts userAccounts) {
        this.userAccounts = userAccounts;
    }

    public void setUser(User usr) {
        this.user = usr;
    }

    public User getUser() {
        return this.user;
    }

    public BookList getBookList() {
        return this.bookList;
    }

    public void setBookList(BookList bookList) {
        this.bookList = bookList;
    }

    public MovieList getMovieList() {
        return movieList;
    }

    public void setMovieList(MovieList movieList) {
        this.movieList = movieList;
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

    public Boolean checkCommandIsQuit(String input) {
        return input.toLowerCase().equals("quit");
    }

    public Boolean checkCommandIsMainMenu(String input) {
        return input.toLowerCase().equals("main menu");
    }

    private Boolean isValidCommand(String command) {
        for (Commands c : Commands.values()) {
            if (c.name().equals(command)) {
                return true;
            }
        }
        return false;
    }

    private String removeSpaceAndConvertToUppercase (String s) {
        return s.replaceAll("\\s+","").toUpperCase();
    }

    private Commands parseCommand(String command) {
        return isValidCommand(command) ? Commands.valueOf(command) : Commands.valueOf("INVALIDOPTION");
    }

    private Process getProcessForCommand(Commands command) {
        return command.getProcess();
    }

    private void runProcess(Process process) {
        process.run(this);
    }

    public void executeCommand(String command) {
        runProcess(getProcessForCommand(parseCommand(removeSpaceAndConvertToUppercase(command))));
    }

    public void start() {
        displayWelcomeMessage();
        executeCommand("Main Menu");
        while (!checkCommandIsQuit(getUser().getUserChoice())) {
            executeCommand(getUser().getUserInput());
        }
    }
}
