package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library patron who can check out and return items.
 *
 * Supports:
 *  - Command Pattern (CheckoutCommand, ReturnCommand modify patron state)
 *  - Observer Pattern (PatronObserver wraps Patron to receive notifications)
 *
 * Each patron maintains a list of checked-out items.
 */
public class Patron {

    // Patron's display name
    private String name;

    // Unique patron ID
    private String id;

    // Items (books, DVDs, etc.) this patron currently has checked out
    private List<Item> checkedOutItems;

    /**
     * Creates a new patron with a name and ID.
     */
    public Patron(String name, String id) {
        this.name = name;
        this.id = id;
        this.checkedOutItems = new ArrayList<>();
    }

    // -------------------------------------------------------------------------
    // Basic getters
    // -------------------------------------------------------------------------

    /**
     * Returns the patron's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the patron's unique ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns all items currently checked out by this patron.
     */
    public List<Item> getCheckedOutItems() {
        return checkedOutItems;
    }

    // -------------------------------------------------------------------------
    // Checkout / Return operations
    // -------------------------------------------------------------------------

    /**
     * Adds an item to the patron's checked-out list.
     * Called by CheckoutCommand.execute().
     */
    public void addCheckedOutItem(Item item) {
        checkedOutItems.add(item);
    }

    /**
     * Removes an item from the patron's checked-out list.
     * Called by ReturnCommand.execute().
     */
    public void removeCheckedOutItem(Item item) {
        checkedOutItems.remove(item);
    }
}
