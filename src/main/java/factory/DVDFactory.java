package factory;

import model.DVD;
import model.Item;

// Concrete Creator in the Factory Method pattern: implements the
// factory method to build DVD items specifically.
public class DVDFactory extends ItemFactory {

    // creator param represents the DVD's director
    @Override
    public Item createItem(String title, String creator, String id) {
        return new DVD(title, creator, id);
    }
}