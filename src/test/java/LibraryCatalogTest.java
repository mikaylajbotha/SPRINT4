import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import catalog.LibraryCatalog;
import model.Book;
import model.DVD;
import model.Item;
import observer.PatronObserver;
import strategy.SearchByCreator;
import strategy.SearchById;
import strategy.SearchByTitle;

public class LibraryCatalogTest {

    // -------------------------------------------------------------------------
    // Singleton Tests
    // -------------------------------------------------------------------------

    @Test
    public void testGetInstanceReturnsSameObject() {
        LibraryCatalog first = LibraryCatalog.getInstance();
        LibraryCatalog second = LibraryCatalog.getInstance();
        assertSame(first, second);
    }

    @Test
    public void testSingletonSharesStateAcrossReferences() {
        LibraryCatalog first = LibraryCatalog.getInstance();
        Book book = new Book("1984", "George Orwell", "0451524934");
        first.addItem(book);

        LibraryCatalog second = LibraryCatalog.getInstance();
        assertEquals(book, second.findById("0451524934"));
    }

    // -------------------------------------------------------------------------
    // Add Item Tests
    // -------------------------------------------------------------------------

    @Test
    public void testAddItemIncreasesCatalogSize() {
        LibraryCatalog catalog = LibraryCatalog.getInstance();
        int before = catalog.getItems().size();

        Book book = new Book("Dune", "Frank Herbert", "0441172717");
        catalog.addItem(book);

        assertEquals(before + 1, catalog.getItems().size());
    }

    // -------------------------------------------------------------------------
    // Search Strategy Tests
    // -------------------------------------------------------------------------

    @Test
    public void testSearchByTitle() {
        LibraryCatalog catalog = LibraryCatalog.getInstance();
        Book book = new Book("Siddhartha", "Hermann Hesse", "0345339681");
        catalog.addItem(book);

        List<Item> results = catalog.search(new SearchByTitle(), "Siddhartha");
        assertTrue(results.contains(book));
    }

    @Test
    public void testSearchByCreator() {
        LibraryCatalog catalog = LibraryCatalog.getInstance();
        DVD dvd = new DVD("Inception", "Christopher Nolan", "DVD001");
        catalog.addItem(dvd);

        List<Item> results = catalog.search(new SearchByCreator(), "Christopher Nolan");
        assertTrue(results.contains(dvd));
    }

    @Test
    public void testSearchById() {
        LibraryCatalog catalog = LibraryCatalog.getInstance();
        Book book = new Book("Dune", "Frank Herbert", "ID777");
        catalog.addItem(book);

        List<Item> results = catalog.search(new SearchById(), "ID777");
        assertTrue(results.contains(book));
    }

    // -------------------------------------------------------------------------
    // Observer Notification Tests
    // -------------------------------------------------------------------------

    @Test
    public void testObserverNotifiedOnReturn() {
        LibraryCatalog catalog = LibraryCatalog.getInstance();

        Book book = new Book("Test Book", "Tester", "ID999");
        catalog.addItem(book);

        // Fake observer to capture notification
        final boolean[] notified = { false };

        PatronObserver observer = item -> {
            if (item.getId().equals("ID999")) {
                notified[0] = true;
            }
        };

        catalog.registerObserver(observer);

        // Return item triggers notification
        catalog.returnItem(book);

        assertTrue(notified[0]);
    }
}
