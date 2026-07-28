package observer;

import model.Item;

// Observer interface: any class that wants to be notified when items
// become available again must implement this.
public interface PatronObserver {
    void update(Item item);
}
