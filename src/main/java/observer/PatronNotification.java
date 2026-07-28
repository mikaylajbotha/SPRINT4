package observer;

import model.Item;
import model.Patron;

/**
 * Concrete Observer: notifies a patron when an item becomes available.
 */
public class PatronNotification implements PatronObserver {

    private final Patron patron;

    public PatronNotification(Patron patron) {
        this.patron = patron;
    }

    @Override
    public void update(Item item) {
        System.out.println("Notification for " + patron.getName() +
                ": \"" + item.getTitle() + "\" is now available.");
    }
}
