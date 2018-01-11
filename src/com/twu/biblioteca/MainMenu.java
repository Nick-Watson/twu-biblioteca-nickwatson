package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu implements Process {
    private ArrayList<String> options = new ArrayList<String>();

    MainMenu() {
        options.add("Login");
        options.add("List Books");
        options.add("List Movies");
        options.add("Checkout Item");
        options.add("Return Item");
    }

    public String displayOptions(Boolean loggedIn) {
        StringBuilder s = new StringBuilder();
        s.append("Main Menu\n\n");
        for (String option : options) {
            s.append("- ");
            if (option.equals("Login")) {
                s.append(loggedIn ? "User Details" : option);
            }
            else s.append(option);
            s.append("\n");
        }
        s.append("\nPlease input an option\nAt anytime type MAIN MENU to return to main menu or QUIT to exit\n");
        return s.toString();
    }

    @Override
    public void run(Library library) {
        library.printToConsole(displayOptions(library.getUser().getLoggedIn()));
    }
}
