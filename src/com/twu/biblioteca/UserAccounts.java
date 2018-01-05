package com.twu.biblioteca;

import java.util.HashMap;

public class UserAccounts {
    private HashMap<String, Account> accounts = new HashMap<String, Account>();

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public void addAccount(String libraryNumber, Account a) {
        getAccounts().put(libraryNumber, a);
    }

    public Account getAccountByLibraryNum(String libraryNumber) {
        return getAccounts().get(libraryNumber);
    }
}
