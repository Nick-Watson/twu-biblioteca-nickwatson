package com.twu.biblioteca;

public class Item {
    private String title;
    private int year;
    private Boolean isCheckedOut = false;

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

    public void setIsCheckedOut(Boolean checkedOut) {
        isCheckedOut = checkedOut;
    }
}
