package factory;

import model.Book;
import model.Item;

/**
 * Concrete Creator in the Factory Method pattern: builds Book items.
 */
public class BookFactory extends ItemFactory {

    // creator = author
    @Override
    public Item createItem(String title, String creator, String id) {
        return new Book(title, creator, id);
    }
}
