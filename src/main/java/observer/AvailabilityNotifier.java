package observer;

import model.Item;
import java.util.ArrayList;
import java.util.List;

// Subject in the Observer pattern: tracks observers and notifies them
// when an item becomes available again.
public class AvailabilityNotifier {

    private List<PatronObserver> observers = new ArrayList<>();

    // Allows a patron (observer) to subscribe for notifications
    public void addObserver(PatronObserver observer) {
        observers.add(observer);
    }

    // Allows a patron to unsubscribe
    public void removeObserver(PatronObserver observer) {
        observers.remove(observer);
    }

    // Notifies all subscribed patrons that an item is now available
    public void notifyAvailable(Item item) {
        for (PatronObserver observer : observers) {
            observer.update(item);
        }
    }
}
