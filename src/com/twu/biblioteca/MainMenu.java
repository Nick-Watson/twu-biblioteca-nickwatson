package com.twu.biblioteca;

import java.util.ArrayList;

public class MainMenu {
    private ArrayList<String> options = new ArrayList<String>();

    MainMenu() {
        options.add("List Books");
        options.add("Checkout Book");

    }

    public String displayOptions() {
        StringBuilder s = new StringBuilder();
        s.append("Main Menu\n\n");
        for (String option : options) {
            s.append("-" + option + "\n");
        }
        s.append("\nPlease select an option or type quit to exit\n");
        return s.toString();
    }
}
