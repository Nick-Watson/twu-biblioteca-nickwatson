package com.twu.biblioteca;

public class Account {
    private String name;
    private Object email;
    private String phone;
    private String libraryNumber;
    private String password;

    Account(String libraryNumber, String password, String name, String email, String phone) {
        this.name =  name;
        this.email = email;
        this.phone = phone;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    private String getName() {
        return name;
    }

    private Object getEmail() {
        return email;
    }

    private String getPhone() {
        return phone;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    private String getPassword() {
        return password;
    }

    public String getUserInformation(){
        StringBuilder s = new StringBuilder();
        s.append("name: ");
        s.append(getName());
        s.append("\n");
        s.append("email: ");
        s.append(getEmail());
        s.append("\n");
        s.append("phone: ");
        s.append(getPhone());
        return s.toString();
    }

    public Boolean authenticate(String libraryNumber, String password) {
        return libraryNumber.equals(getLibraryNumber()) && password.equals(getPassword());
    }
}
