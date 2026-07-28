package observer;

import model.Item;

/**
 * Observer interface in the Observer Pattern.
 *
 * Any class that wants to be notified when an item becomes available
 * must implement this interface.
 *
 * Concrete implementation:
 *   - PatronNotification (wraps a Patron and prints a message)
 */
public interface PatronObserver {

    /**
     * Called by AvailabilityNotifier when an item becomes available.
     *
     * @param item The item that is now available.
     */
    void update(Item item);
}
