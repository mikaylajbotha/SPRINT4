package factory;

import builder.DVDBuilder;
import model.Item;

/**
 * Concrete Factory for creating DVD items.
 */
public class DVDFactory implements ItemFactory {

    @Override
    public Item createItem(String title, String director, String catalogNumber) {
        return new DVDBuilder()
                .withTitle(title)
                .withDirector(director)
                .withCatalogNumber(catalogNumber)
                .build();
    }
}
