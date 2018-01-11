package com.twu.biblioteca;

public class TestData {
    public static String getMenuDisplayNoLogin() {
        return "Main Menu\n\n- Login\n- List Books\n- List Movies\n- Checkout Item\n- Return Item\n\nPlease input an option (case sensitive)\nAt anytime type Main Menu to return to main menu or Quit to exit\n";
    }

    public static String getMenuDisplayLoggedIn() {
        return "Main Menu\n\n- User Details\n- List Books\n- List Movies\n- Checkout Item\n- Return Item\n\nPlease input an option (case sensitive)\nAt anytime type Main Menu to return to main menu or Quit to exit\n";
    }

    public static String getUserInformation() {
        return "name: nick watson\nemail: nickwatson@gmail.com\nphone: 07807388815";
    }

    public static Account getAccount() {
        return new Account("111-2222", "biblio","nick watson", "nickwatson@gmail.com", "07807388815");
    }

    public static Library getTestLibrary() {
        Library tester;
        tester = new Library("Bangalore Public Library");
        tester.setBookList(Data.buildBookList());
        tester.setMovieList(Data.buildMovieList());
        tester.setUserAccounts(Data.buildUserAccounts());
        tester.setUser(new User());
        return tester;
    }
}
