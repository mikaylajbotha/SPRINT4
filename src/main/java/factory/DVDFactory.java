package factory;

import model.DVD;
import model.Item;

/**
 * Concrete Creator in the Factory Method pattern: builds DVD items.
 */
public class DVDFactory extends ItemFactory {

    // creator = director
    @Override
    public Item createItem(String title, String creator, String id) {
        return new DVD(title, creator, id);
    }
}
