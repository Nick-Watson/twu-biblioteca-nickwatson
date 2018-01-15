package com.twu.biblioteca;

public class Login implements Process{

    public String getUserLibraryNumber(User user) {
        System.out.println("Please input library number");
        return user.getUserInput();
    }

    public String getUserPassword(User user) {
        System.out.println("Please input password");
        return user.getUserInput();
    }

    public Boolean authenticate(String libraryNumber, String password, UserAccounts accounts) {
        return accounts.authenticate(libraryNumber, password);
    }

    public void updateUserLoginAndAccount(User user, Account account) {
        user.setLoggedIn(true);
        user.setAccount(account);
    }

    public void processLogin(Boolean bool, User user, Account account){
        if (bool) {
            updateUserLoginAndAccount(user, account);
            System.out.println("login success");
        } else System.out.println("login fail, try again");
    }

    @Override
    public void run(Library library) {
        while (!library.getUser().getLoggedIn()) {
            String libraryNumber = getUserLibraryNumber(library.getUser());
            String password = getUserPassword(library.getUser());
            processLogin(authenticate(libraryNumber, password, library.getUserAccounts()), library.getUser(), library.getUserAccounts().getAccountByLibraryNum(libraryNumber));
        }
    }
}
