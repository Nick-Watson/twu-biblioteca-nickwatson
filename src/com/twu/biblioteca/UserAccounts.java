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

    private Boolean checkAccountExists(String libraryNumber) {
        return getAccounts().containsKey(libraryNumber);
    }
    public Account getAccountByLibraryNum(String libraryNumber) {
        return getAccounts().get(libraryNumber);
    }

    public Boolean authenticate(String libraryNumber, String password) {
        return checkAccountExists(libraryNumber) && getAccountByLibraryNum(libraryNumber).authenticate(libraryNumber, password);
    }
}
