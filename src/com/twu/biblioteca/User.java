package com.twu.biblioteca;

import java.util.Scanner;

public class User {
    private String userChoice = "";

    public String getUserChoice() {
        return this.userChoice;
    }

    public String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        try{
            String s = scanner.nextLine().toLowerCase();
            this.userChoice = s;
            return s;
        }
        catch (Exception e) {
            return e.toString();
        }
    }
}
