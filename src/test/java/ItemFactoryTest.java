import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import factory.BookFactory;
import factory.DVDFactory;
import factory.ItemFactory;

import model.Book;
import model.DVD;
import model.Item;

public class ItemFactoryTest {

    @Test
    public void testBookFactoryCreatesBook() {
        ItemFactory factory = new BookFactory();
        Item item = factory.createItem("The Hobbit", "J.R.R. Tolkien", "ISBN123");

        assertInstanceOf(Book.class, item);
        assertEquals("The Hobbit", item.getTitle());
        assertEquals("J.R.R. Tolkien", item.getCreator());
        assertEquals("ISBN123", item.getId());
        assertEquals("Book", item.getType());
        assertTrue(item.isAvailable());
    }

    @Test
    public void testDVDFactoryCreatesDVD() {
        ItemFactory factory = new DVDFactory();
        Item item = factory.createItem("Inception", "Christopher Nolan", "DVD001");

        assertInstanceOf(DVD.class, item);
        assertEquals("Inception", item.getTitle());
        assertEquals("Christopher Nolan", item.getCreator());
        assertEquals("DVD001", item.getId());
        assertEquals("DVD", item.getType());
        assertTrue(item.isAvailable());
    }
}
