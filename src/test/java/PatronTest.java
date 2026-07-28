import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.Book;
import model.DVD;
import model.Patron;

public class PatronTest {

    // -------------------------------------------------------------------------
    // Basic Creation Tests
    // -------------------------------------------------------------------------

    @Test
    public void testPatronCreation() {
        Patron patron = new Patron("Alex Rivera", "P-100");

        assertEquals("Alex Rivera", patron.getName());
        assertEquals("P-100", patron.getId());
    }

    @Test
    public void testPatronStartsWithNoCheckedOutItems() {
        Patron patron = new Patron("Alex Rivera", "P-100");
        assertTrue(patron.getCheckedOutItems().isEmpty());
    }

    // -------------------------------------------------------------------------
    // Add Item Tests
    // -------------------------------------------------------------------------

    @Test
    public void testAddingItemUpdatesCheckedOutList() {
        Patron patron = new Patron("Alex Rivera", "P-100");
        Book book = new Book("Dune", "Frank Herbert", "0441172717");

        patron.addCheckedOutItem(book);

        assertEquals(1, patron.getCheckedOutItems().size());
        assertEquals(book, patron.getCheckedOutItems().get(0));
    }

    @Test
    public void testAddingMultipleItems() {
        Patron patron = new Patron("Alex Rivera", "P-100");
        Book book = new Book("Dune", "Frank Herbert", "0441172717");
        DVD dvd = new DVD("Inception", "Christopher Nolan", "DVD001");

        patron.addCheckedOutItem(book);
        patron.addCheckedOutItem(dvd);

        assertEquals(2, patron.getCheckedOutItems().size());
        assertTrue(patron.getCheckedOutItems().contains(book));
        assertTrue(patron.getCheckedOutItems().contains(dvd));
    }

    // -------------------------------------------------------------------------
    // Remove Item Tests
    // -------------------------------------------------------------------------

    @Test
    public void testRemovingItemUpdatesCheckedOutList() {
        Patron patron = new Patron("Alex Rivera", "P-100");
        Book book = new Book("Dune", "Frank Herbert", "0441172717");

        patron.addCheckedOutItem(book);
        patron.removeCheckedOutItem(book);

        assertTrue(patron.getCheckedOutItems().isEmpty());
    }

    @Test
    public void testRemovingOneItemLeavesOthers() {
        Patron patron = new Patron("Alex Rivera", "P-100");
        Book book1 = new Book("Dune", "Frank Herbert", "0441172717");
        Book book2 = new Book("1984", "George Orwell", "0451524934");

        patron.addCheckedOutItem(book1);
        patron.addCheckedOutItem(book2);

        patron.removeCheckedOutItem(book1);

        assertEquals(1, patron.getCheckedOutItems().size());
        assertTrue(patron.getCheckedOutItems().contains(book2));
    }

    @Test
    public void testRemovingNonexistentItemDoesNothing() {
        Patron patron = new Patron("Alex Rivera", "P-100");
        Book book1 = new Book("Dune", "Frank Herbert", "0441172717");
        Book book2 = new Book("1984", "George Orwell", "0451524934");

        patron.addCheckedOutItem(book1);
        patron.removeCheckedOutItem(book2); // should do nothing

        assertEquals(1, patron.getCheckedOutItems().size());
        assertTrue(patron.getCheckedOutItems().contains(book1));
    }
}
