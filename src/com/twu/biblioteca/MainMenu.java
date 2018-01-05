package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu {
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
                s.append(loggedIn ? "User" : option);
            }
            else s.append(option);
            s.append("\n");
        }
        s.append("\nPlease select an option\n(At anytime type main menu to return to main menu or quit to exit)\n");
        return s.toString();
    }
}
