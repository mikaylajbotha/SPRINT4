package catalog;

import model.Item;
import observer.PatronObserver;
import strategy.SearchStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton catalog that stores all items and supports searching.
 *
 * Integrates:
 *  - Singleton Pattern (one shared catalog)
 *  - Strategy Pattern (search strategies)
 *  - Observer Pattern (patrons notified when items become available)
 */
public class LibraryCatalog {

    // -------------------------------------------------------------------------
    // Singleton
    // -------------------------------------------------------------------------

    private static LibraryCatalog instance;

    public static LibraryCatalog getInstance() {
        if (instance == null) {
            instance = new LibraryCatalog();
        }
        return instance;
    }

    // -------------------------------------------------------------------------
    // Fields
    // -------------------------------------------------------------------------

    private final List<Item> items;
    private final List<PatronObserver> observers;

    // Private constructor (Singleton)
    private LibraryCatalog() {
        this.items = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    // -------------------------------------------------------------------------
    // Observer Pattern
    // -------------------------------------------------------------------------

    public void registerObserver(PatronObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(PatronObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(Item item) {
        for (PatronObserver observer : observers) {
            observer.update(item);
        }
    }

    // -------------------------------------------------------------------------
    // Catalog Operations
    // -------------------------------------------------------------------------

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public Item findById(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    // -------------------------------------------------------------------------
    // Return Item (Triggers Observer Notification)
    // -------------------------------------------------------------------------

    public void returnItem(Item item) {
        item.setAvailable(true);
        notifyObservers(item);
    }

    // -------------------------------------------------------------------------
    // Strategy Pattern Search
    // -------------------------------------------------------------------------

    public List<Item> search(SearchStrategy strategy, String query) {
        return strategy.search(items, query);
    }
}
