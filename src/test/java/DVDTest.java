import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import model.DVD;

public class DVDTest {

    // Confirms all constructor values are stored and returned correctly
    @Test
    public void testDVDCreation() {
        DVD dvd = new DVD("Aquamarine", "Elizabeth Allen Rosenbaum", "DVD-1001");

        assertEquals("Aquamarine", dvd.getTitle());
        assertEquals("Elizabeth Allen Rosenbaum", dvd.getDirector());
        assertEquals("DVD-1001", dvd.getId());
    }

    // A new DVD should be available by default
    @Test
    public void testDVDIsAvailableByDefault() {
        DVD dvd = new DVD("Aquamarine", "Elizabeth Allen Rosenbaum", "DVD-1001");
        assertTrue(dvd.isAvailable());
    }

    // setAvailable(false) should mark the DVD as checked out
    @Test
    public void testSetAvailableFalse() {
        DVD dvd = new DVD("Aquamarine", "Elizabeth Allen Rosenbaum", "DVD-1001");
        dvd.setAvailable(false);
        assertFalse(dvd.isAvailable());
    }

    // getType() should identify this item as a DVD, per the Item interface
    @Test
    public void testDVDTypeIsDVD() {
        DVD dvd = new DVD("Aquamarine", "Elizabeth Allen Rosenbaum", "DVD-1001");
        assertEquals("DVD", dvd.getType());
    }
}
