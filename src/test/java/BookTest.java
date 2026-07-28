import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import model.Book;

public class BookTest {

    @Test
    public void testBookCreation() {
        Book book = new Book("Siddhartha", "Hermann Hesse", "0345339681");

        assertEquals("Siddhartha", book.getTitle());
        assertEquals("Hermann Hesse", book.getAuthor());
        assertEquals("0345339681", book.getId());
    }

    @Test
    public void testBookIsAvailableByDefault() {
        Book book = new Book("Siddhartha", "Hermann Hesse", "0345339681");
        assertTrue(book.isAvailable());
    }

    @Test
    public void testBookTypeIsBook() {
        Book book = new Book("Siddhartha", "Hermann Hesse", "0345339681");
        assertEquals("Book", book.getType());
    }

    @Test
    public void testOptionalFieldsFullConstructor() {
        Book book = new Book("Dune", "Frank Herbert", "12345", "Sci-Fi", 1965);

        assertEquals("Sci-Fi", book.getGenre());
        assertEquals(1965, book.getPublicationYear());
    }

    @Test
    public void testOptionalFieldsDefaultConstructor() {
        Book book = new Book("Dune", "Frank Herbert", "12345");

        assertEquals(null, book.getGenre());
        assertEquals(0, book.getPublicationYear());
    }

    @Test
    public void testAvailabilityToggle() {
        Book book = new Book("Siddhartha", "Hermann Hesse", "0345339681");

        book.setAvailable(false);
        assertTrue(!book.isAvailable());

        book.setAvailable(true);
        assertTrue(book.isAvailable());
    }
}
