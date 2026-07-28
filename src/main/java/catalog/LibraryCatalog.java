package catalog;

import model.Item;
import java.util.ArrayList;
import java.util.List;

// Singleton Pattern: only one LibraryCatalog should exist for the whole
// application, since it represents the single shared collection of items.
// Constructor is private; every caller gets the same instance via getInstance().
public class LibraryCatalog {

    // The one shared instance
    private static LibraryCatalog instance;

    // All items currently in the catalog (Books, DVDs, etc.)
    private List<Item> items;

    // Private so no other class can create a second catalog
    private LibraryCatalog() {
        this.items = new ArrayList<>();
    }

    // Lazily creates the instance on first call, then always returns that same one
    public static LibraryCatalog getInstance() {
        if (instance == null) {
            instance = new LibraryCatalog();
        }
        return instance;
    }

    // Adds an item to the catalog
    public void addItem(Item item) {
        items.add(item);
    }

    // Returns all items in the catalog
    public List<Item> getItems() {
        return items;
    }

    // Looks up an item by id; returns null if none match
    public Item findById(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }
}