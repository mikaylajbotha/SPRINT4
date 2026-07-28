import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;

import factory.BookFactory;
import factory.DVDFactory;
import factory.ItemFactory;
import model.Book;
import model.DVD;
import model.Item;

public class ItemFactoryTest {

    // Tests that BookFactory's factory method produces a Book
    @Test
    public void testBookFactoryCreatesBook() {
        ItemFactory factory = new BookFactory();
        Item item = factory.createItem("The Hobbit", "J.R.R. Tolkien", "0345339681");

        assertInstanceOf(Book.class, item);
        assertEquals("The Hobbit", item.getTitle());
        assertEquals("Book", item.getType());
    }

    // Tests that DVDFactory's factory method produces a DVD
    @Test
    public void testDVDFactoryCreatesDVD() {
        ItemFactory factory = new DVDFactory();
        Item item = factory.createItem("Inception", "Christopher Nolan", "DVD-1001");

        assertInstanceOf(DVD.class, item);
        assertEquals("DVD", item.getType());
    }

    // Tests that items are available immediately after creation, regardless of factory
    @Test
    public void testCreatedItemsAreAvailableByDefault() {
        ItemFactory bookFactory = new BookFactory();
        ItemFactory dvdFactory = new DVDFactory();

        Item book = bookFactory.createItem("Dune", "Frank Herbert", "0441172717");
        Item dvd = dvdFactory.createItem("Arrival", "Denis Villeneuve", "DVD-2002");

        assertTrue(book.isAvailable());
        assertTrue(dvd.isAvailable());
    }
}
