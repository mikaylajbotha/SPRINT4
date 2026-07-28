package factory;

import model.Book;
import model.Item;

// Concrete Creator in the Factory Method pattern: implements the
// factory method to build Book items specifically.
public class BookFactory extends ItemFactory {

    // creator param represents the book's author
    @Override
    public Item createItem(String title, String creator, String id) {
        return new Book(title, creator, id);
    }
}