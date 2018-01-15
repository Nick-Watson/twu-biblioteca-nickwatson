package com.twu.biblioteca;

import java.util.Scanner;

public class User {
    private String userChoice = "";
    private Boolean loggedIn = false;
    private Account account = null;
    private Scanner scanner = new Scanner(System.in);

    public String getUserChoice() {
        return this.userChoice;
    }

    public String getUserInput() {
        try{
            String s = scanner.nextLine();
            this.userChoice = s;
            return s;
        }
        catch (Exception e) {
            return e.toString();
        }
    }

    public String getUserInformation() {
        return getAccount().getUserInformation();
    }

    public String getUserLibraryNumber(){
        return getAccount().getLibraryNumber();
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
