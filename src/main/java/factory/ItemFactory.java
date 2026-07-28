package factory;

import model.Item;

/**
 * Factory Method Pattern:
 * ItemFactory defines the interface for creating library items.
 */
public interface ItemFactory {
    Item createItem(String title, String creator, String id);
}
