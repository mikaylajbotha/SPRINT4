import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

import catalog.LibraryCatalog;
import model.Book;

public class LibraryCatalogTest {

    // Adding an item should increase the catalog's size by one
    @Test
    public void testAddItemIncreasesCatalogSize() {
        LibraryCatalog catalog = LibraryCatalog.getInstance();
        int before = catalog.getItems().size();

        Book book = new Book("Dune", "Frank Herbert", "0441172717");
        catalog.addItem(book);

        assertEquals(before + 1, catalog.getItems().size());
    }

    // getInstance() should always return the same shared instance (Singleton)
    @Test
    public void testGetInstanceReturnsSameObject() {
        LibraryCatalog first = LibraryCatalog.getInstance();
        LibraryCatalog second = LibraryCatalog.getInstance();

        assertSame(first, second);
    }

    // State added through one reference should be visible through another
    @Test
    public void testSingletonSharesStateAcrossReferences() {
        LibraryCatalog first = LibraryCatalog.getInstance();
        Book book = new Book("1984", "George Orwell", "0451524934");
        first.addItem(book);

        LibraryCatalog second = LibraryCatalog.getInstance();

        assertEquals(book, second.findById("0451524934"));
    }
}
