package observer;

import model.Item;
import java.util.ArrayList;
import java.util.List;

/**
 * Subject in the Observer Pattern.
 *
 * AvailabilityNotifier maintains a list of observers (PatronObserver)
 * and notifies them whenever an item becomes available again.
 *
 * LibraryCatalog.returnItem() should call notifyAvailable(item)
 * after marking the item available.
 */
public class AvailabilityNotifier {

    // All observers subscribed for availability notifications
    private final List<PatronObserver> observers = new ArrayList<>();

    /**
     * Registers a new observer (e.g., a PatronObserver).
     */
    public void addObserver(PatronObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes an observer.
     */
    public void removeObserver(PatronObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies all observers that an item is now available.
     */
    public void notifyAvailable(Item item) {
        for (PatronObserver observer : observers) {
            observer.update(item);
        }
    }
}
