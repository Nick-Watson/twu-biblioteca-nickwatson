package com.twu.biblioteca;

import java.util.ArrayList;

public class ItemList {
    private ArrayList<Item> availableItems = new ArrayList<Item>();

    public ArrayList<Item> getAvailableItems() {
        return this.availableItems;
    }

    public void addItem(Item i) {
        this.availableItems.add(i);
    }

    public Boolean itemIsAvailable(String item) {
        for (Item i : getAvailableItems()) {
            if (i.getTitle().toLowerCase().equals(item.toLowerCase()) && !i.isCheckedOut()) {
                return true;
            }
        }
        return false;
    }

    public Boolean itemCanBeReturned(String item) {
        for (Item i : getAvailableItems()) {
            if (i.getTitle().toLowerCase().equals(item.toLowerCase()) && i.isCheckedOut()) {
                return true;
            }
        }
        return false;
    }

    public void checkoutItem(String item, String libraryNumber) {
        for (Item i : getAvailableItems()) {
            if (i.getTitle().toLowerCase().equals(item.toLowerCase()) && !i.isCheckedOut()) {
                i.checkoutItem(libraryNumber);
            }
        }
    }

    public void returnItem(String item) {
        for (Item i : getAvailableItems()) {
            if (i.getTitle().toLowerCase().equals(item.toLowerCase()) && i.isCheckedOut()) {
                i.returnItem();
            }
        }
    }
}
