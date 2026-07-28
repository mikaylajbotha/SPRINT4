package factory;

import builder.BookBuilder;
import model.Item;

/**
 * Concrete Factory for creating Book items.
 */
public class BookFactory implements ItemFactory {

    @Override
    public Item createItem(String title, String author, String isbn) {
        return new BookBuilder()
                .title(title)
                .author(author)
                .isbn(isbn)
                .build();
    }
}
