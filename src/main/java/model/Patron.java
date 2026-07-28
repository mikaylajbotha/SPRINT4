package model;

import java.util.ArrayList;
import java.util.List;

public class Patron {

    // Patron's display name
    private String name;

    // Unique patron ID
    private String id;

    // Items (books, DVDs, etc.) this patron currently has checked out
    private List<Item> checkedOutItems;

    // Sets up a new patron with name, ID, and an empty checked-out list
    public Patron(String name, String id) {
        this.name = name;
        this.id = id;
        this.checkedOutItems = new ArrayList<>();
    }

    // Returns patron's name
    public String getName() {
        return name;
    }

    // Returns patron's ID
    public String getId() {
        return id;
    }

    // Returns the patron's currently checked-out items
    public List<Item> getCheckedOutItems() {
        return checkedOutItems;
    }

    // Adds an item to this patron's checked-out list
    public void addCheckedOutItem(Item item) {
        checkedOutItems.add(item);
    }

    // Removes an item from this patron's checked-out list (used on return/undo)
    public void removeCheckedOutItem(Item item) {
        checkedOutItems.remove(item);
    }
}
