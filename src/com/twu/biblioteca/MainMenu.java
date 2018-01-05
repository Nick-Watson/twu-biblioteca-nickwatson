package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu {
    private ArrayList<String> options = new ArrayList<String>();

    MainMenu() {
        options.add("List Books");
        options.add("List Movies");
        options.add("Checkout Item");
        options.add("Return Item");
    }

    public String displayOptions() {
        StringBuilder s = new StringBuilder();
        s.append("Main Menu\n\n");
        for (String option : options) {
            s.append("- ");
            s.append(option);
            s.append("\n");
        }
        s.append("\nPlease select an option or type quit at anytime to exit\n");
        return s.toString();
    }
}
