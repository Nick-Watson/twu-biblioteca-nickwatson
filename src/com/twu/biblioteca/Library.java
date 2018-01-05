package com.twu.biblioteca;

public class Library {
    private String name;
    private MainMenu mainMenu = new MainMenu();
    private UserAccounts userAccounts = null;
    private BookList bookList = null;
    private MovieList movieList = null;
    private User user = null;

    Library (String name) {
        this.name = name;
    }

    private String getLibraryName() {
        return this.name;
    }

    private UserAccounts getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(UserAccounts userAccounts) {
        this.userAccounts = userAccounts;
    }

    public void setUser(User usr) {
        this.user = usr;
    }

    private User getUser() {
        return this.user;
    }

    private BookList getBookList() {
        return this.bookList;
    }

    public void setBookList(BookList bookList) {
        this.bookList = bookList;
    }

    private MovieList getMovieList() {
        return movieList;
    }

    public void setMovieList(MovieList movieList) {
        this.movieList = movieList;
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
        printToConsole(getMainMenu().displayOptions(getUser().getLoggedIn()));
    }

    private void processLogin() {
        while (!getUser().getLoggedIn()) {
            printToConsole("Please input library number");
            String libraryNumber = getUser().getUserInput();
            printToConsole("Please input password");
            String password = getUser().getUserInput();

            if (getUserAccounts().authenticate(libraryNumber, password)) {
                getUser().setLoggedIn(true);
                getUser().setAccount(getUserAccounts().getAccountByLibraryNum(libraryNumber));
                printToConsole("login success");
            } else printToConsole("login fail, try again");
        }
    }

    private void processUserInformation() {
        printToConsole(getUser().getUserInformation());
    }

    private void processListBooks() {
        printToConsole(getBookList().displayList());
    }

    private void processListMovies() {
        printToConsole(getMovieList().displayList());
    }

    private String checkoutItemInstructions() {
        return "Input the item you would like to checkout or main menu to go back";
    }

    private String invalidCheckoutMessage() {
        return "That item is not available";
    }

    private String returnItemInstructions() {
        return "Input the item you would like to return or main menu to go back";
    }

    private String invalidReturnMessage() {
        return "That is not a valid item to return";
    }

    private Boolean checkCommandIsQuit (String input) {
        return input.equals("quit");
    }

    private Boolean checkCommandIsMainMenu (String input) {
        return input.equals("main menu");
    }

    private Boolean processBookCheckout (String book) {
        getBookList().checkoutItem(book, getUser().getUserLibraryNumber());
        printToConsole(getBookList().checkoutSuccessMessage());
        return true;
    }

    private Boolean processMovieCheckout (String movie) {
        getMovieList().checkoutItem(movie, getUser().getUserLibraryNumber());
        printToConsole(getMovieList().checkoutSuccessMessage());
        return true;
    }

    private Boolean processBookReturn(String book) {
        getBookList().returnItem(book);
        printToConsole(getBookList().returnSuccessMessage());
        return true;
    }

    private Boolean processMovieReturn(String movie) {
        getMovieList().returnItem(movie);
        printToConsole(getMovieList().returnSuccessMessage());
        return true;
    }

    private void processCheckoutItem() {
        if (!getUser().getLoggedIn()) processLogin();
        printToConsole(checkoutItemInstructions());
        Boolean checkoutSuccess = false;
        String input = getUser().getUserInput();
        while (!checkoutSuccess && !checkCommandIsQuit(input) && !checkCommandIsMainMenu(input)) {
            if (getBookList().itemIsAvailable(input)) checkoutSuccess = processBookCheckout(input);
            else if (getMovieList().itemIsAvailable(input))checkoutSuccess = processMovieCheckout(input);
            else {
                printToConsole(invalidCheckoutMessage());
                input = getUser().getUserInput();
            }
        }
        if (checkCommandIsQuit(input)) processCommand("quit");
        if (checkCommandIsMainMenu(input)) processCommand("main menu");
    }

    private void processReturnItem() {
        if (!getUser().getLoggedIn()) processLogin();
        printToConsole(returnItemInstructions());
        Boolean returnSuccess = false;
        String input = getUser().getUserInput();
        while (!returnSuccess && !checkCommandIsQuit(input) && !checkCommandIsMainMenu(input)) {
            if (getBookList().itemCanBeReturned(input)) returnSuccess = processBookReturn(input);
            else if (getMovieList().itemCanBeReturned(input))returnSuccess = processMovieReturn(input);
            else {
                printToConsole(invalidReturnMessage());
                input = getUser().getUserInput();
            }
        }
        if (checkCommandIsQuit(input)) processCommand("quit");
        if (checkCommandIsMainMenu(input)) processCommand("main menu");
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
        else if (command.equals("main menu")) displayMainMenu();
        else if (command.equals("login")) processLogin();
        else if (command.equals("user")) processUserInformation();
        else if (command.equals("list books")) processListBooks();
        else if (command.equals("list movies")) processListMovies();
        else if (command.equals("checkout item")) processCheckoutItem();
        else if (command.equals("return item")) processReturnItem();
        else processInvalidOption();
    }

    public void run() {
        displayWelcomeMessage();
        displayMainMenu();
        while (!checkCommandIsQuit(getUser().getUserChoice())) {
            processCommand(getUser().getUserInput());
        }
    }
}
