import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import builder.BookBuilder;
import model.Book;

public class BookTest {

    // -------------------------------------------------------------------------
    // Constructor Tests
    // -------------------------------------------------------------------------

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

    // -------------------------------------------------------------------------
    // Builder Tests
    // -------------------------------------------------------------------------

    @Test
    public void testBuilderCreatesRequiredFields() {
        Book book = new BookBuilder()
                .title("1984")
                .author("George Orwell")
                .isbn("ISBN-1984")
                .build();

        assertEquals("1984", book.getTitle());
        assertEquals("George Orwell", book.getAuthor());
        assertEquals("ISBN-1984", book.getId());
        assertTrue(book.isAvailable());
    }

    @Test
    public void testBuilderOptionalFields() {
        Book book = new BookBuilder()
                .title("Dune")
                .author("Frank Herbert")
                .isbn("12345")
                .genre("Sci-Fi")
                .publicationYear(1965)
                .build();

        assertEquals("Sci-Fi", book.getGenre());
        assertEquals(1965, book.getPublicationYear());
    }

    @Test
    public void testBuilderOptionalFieldsDefault() {
        Book book = new BookBuilder()
                .title("Dune")
                .author("Frank Herbert")
                .isbn("12345")
                .build();

        assertEquals(null, book.getGenre());
        assertEquals(0, book.getPublicationYear());
    }
}
