package com.twu.biblioteca;

public class BookList extends ItemList{
    private String headerToString() {
        return String.format("%-25s%-25s%-25s\n","Title","Author","Year");
    }

    private String formatBook(Book book) {
        return String.format("%-25s%-25s%-25s\n",book.getTitle(),book.getAuthor(),book.getYear());
    }

    private String booksToString() {
        StringBuilder s = new StringBuilder();

        for (Item b : getAvailableItems()) {
            if (!b.isCheckedOut()) s.append(formatBook((Book) b));
        }
        return s.toString();
    }

    public String displayList() {
        return headerToString() + booksToString();
    }

    public String checkoutSuccessMessage() {
        return "Thank you! Enjoy the book";
    }

    public String returnSuccessMessage() {
        return "Thank you for returning the book";
    }

}
