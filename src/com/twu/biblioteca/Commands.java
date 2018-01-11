package com.twu.biblioteca;

public enum Commands {
    QUIT("Quit"),
    MAINMENU("MainMenu"),
    LOGIN("Login"),
    USERDETAILS("UserDetails"),
    LISTBOOKS("ListBooks"),
    LISTMOVIES("ListMovies"),
    CHECKOUTITEM("CheckoutItem"),
    RETURNITEM("ReturnItem"),
    INVALIDOPTION("InvalidOption");
    String input;

    Commands(String command) {
        this.input = command;
    }

    public Process getProcess() {
        try {
            return (Process) Class.forName("com.twu.biblioteca." + input).newInstance();
        } catch (Exception e) {
            return (Process) Commands.valueOf("INVALIDOPTION").getProcess();
        }
    }
}
