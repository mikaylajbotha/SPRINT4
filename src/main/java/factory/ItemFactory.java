package factory;

import model.Item;

// Factory Method Pattern: declares a method for creating an Item without
// specifying its concrete class. Subclasses override it to decide what
// gets built. Client code depends only on this abstract type, so new
// item types can be added without touching existing code.
public abstract class ItemFactory {

    // Factory method, implemented by each concrete factory
    public abstract Item createItem(String title, String creator, String id);
}