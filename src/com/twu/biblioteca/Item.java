package com.twu.biblioteca;

public class Item {
    private String title;
    private int year;
    private Boolean isCheckedOut = false;
    private String checkedOutBy = null;

    Item(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public Boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutBy() {
        return checkedOutBy;
    }

    public void checkoutItem(String libraryNumber) {
        isCheckedOut = true;
        checkedOutBy = libraryNumber;
    }

    public void returnItem() {
        isCheckedOut = false;
        checkedOutBy = null;
    }
}
