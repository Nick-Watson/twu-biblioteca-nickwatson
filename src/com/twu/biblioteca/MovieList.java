package com.twu.biblioteca;

public class MovieList extends ItemList {
    private String headerToString() {
        return String.format("%-25s%-25s%-25s%-25s\n","Title","Director","Year", "Rating");
    }

    private String formatMovie(Movie movie) {
        return String.format("%-25s%-25s%-25s%-25s\n",movie.getTitle(),movie.getDirector(),movie.getYear(), movie.getRating());
    }

    private String moviesToString() {
        StringBuilder s = new StringBuilder();

        for (Item m : getAvailableItems()) {
            if (!m.isCheckedOut()) s.append(formatMovie((Movie) m));
        }
        return s.toString();
    }

    public String displayList() {
        return headerToString() + moviesToString();
    }

    public String checkoutSuccessMessage() {
        return "Thank you! Enjoy the movie";
    }

    public String returnSuccessMessage() {
        return "Thank you for returning the movie";
    }
}
