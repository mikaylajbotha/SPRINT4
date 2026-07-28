import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.Book;
import model.Patron;

public class PatronTest {

    // Tests that a patron is created with the correct name and id
    @Test
    public void testPatronCreation() {
        Patron patron = new Patron("Alex Rivera", "P-100");

        assertEquals("Alex Rivera", patron.getName());
        assertEquals("P-100", patron.getId());
    }

    // Tests that a new patron starts with no checked-out items
    @Test
    public void testPatronStartsWithNoCheckedOutItems() {
        Patron patron = new Patron("Alex Rivera", "P-100");

        assertTrue(patron.getCheckedOutItems().isEmpty());
    }

    // Tests that adding an item updates the checked-out list
    @Test
    public void testAddingItemUpdatesCheckedOutList() {
        Patron patron = new Patron("Alex Rivera", "P-100");
        Book book = new Book("Dune", "Frank Herbert", "0441172717");

        patron.addCheckedOutItem(book);

        assertEquals(1, patron.getCheckedOutItems().size());
        assertEquals(book, patron.getCheckedOutItems().get(0));
    }
}
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.Book;
import model.Patron;

public class PatronTest {

    // Tests that a patron is created with the correct name and id
    @Test
    public void testPatronCreation() {
        Patron patron = new Patron("Alex Rivera", "P-100");

        assertEquals("Alex Rivera", patron.getName());
        assertEquals("P-100", patron.getId());
    }

    // Tests that a new patron starts with no checked-out items
    @Test
    public void testPatronStartsWithNoCheckedOutItems() {
        Patron patron = new Patron("Alex Rivera", "P-100");

        assertTrue(patron.getCheckedOutItems().isEmpty());
    }

    // Tests that adding an item updates the checked-out list
    @Test
    public void testAddingItemUpdatesCheckedOutList() {
        Patron patron = new Patron("Alex Rivera", "P-100");
        Book book = new Book("Dune", "Frank Herbert", "0441172717");

        patron.addCheckedOutItem(book);

        assertEquals(1, patron.getCheckedOutItems().size());
        assertEquals(book, patron.getCheckedOutItems().get(0));
    }
}
