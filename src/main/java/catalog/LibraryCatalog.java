package catalog;

import model.Item;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton Pattern: only one LibraryCatalog exists for the whole application.
 * It stores all items (Books, DVDs, etc.) and provides lookup and retrieval.
 */
public class LibraryCatalog {

    // The one shared instance
    private static LibraryCatalog instance;

    // All items currently in the catalog
    private final List<Item> items;

    // Private constructor prevents external instantiation
    private LibraryCatalog() {
        this.items = new ArrayList<>();
    }

    // Lazily creates the instance on first call, then always returns the same one
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
