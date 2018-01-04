package com.twu.biblioteca;

public class Movie extends Item {
    private String director;
    private int rating;

    Movie(String title, String director, int year, int rating){
        super(title, year);
        this.director = director;
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }
}
