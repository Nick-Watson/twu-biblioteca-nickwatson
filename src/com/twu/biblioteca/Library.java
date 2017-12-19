package com.twu.biblioteca;

public class Library {
    String name;
    Library (String name) {
        this.name = name;
    }

    private String getLibraryName() {
        return this.name;
    }

    public String createWelcomeMessage(){
        return "Welcome to the " + getLibraryName();
    }

    public void printWelcomeMessage() {
        System.out.println(createWelcomeMessage());
    }
}
