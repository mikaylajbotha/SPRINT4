import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import model.DVD;

public class DVDTest {

    @Test
    public void testDVDCreation() {
        DVD dvd = new DVD("Inception", "Christopher Nolan", "DVD001");

        assertEquals("Inception", dvd.getTitle());
        assertEquals("Christopher Nolan", dvd.getDirector());
        assertEquals("DVD001", dvd.getId());
    }

    @Test
    public void testDVDIsAvailableByDefault() {
        DVD dvd = new DVD("Inception", "Christopher Nolan", "DVD001");
        assertTrue(dvd.isAvailable());
    }

    @Test
    public void testDVDTypeIsDVD() {
        DVD dvd = new DVD("Inception", "Christopher Nolan", "DVD001");
        assertEquals("DVD", dvd.getType());
    }

    @Test
    public void testCreatorReturnsDirector() {
        DVD dvd = new DVD("Inception", "Christopher Nolan", "DVD001");
        assertEquals("Christopher Nolan", dvd.getCreator());
    }

    @Test
    public void testAvailabilityToggle() {
        DVD dvd = new DVD("Inception", "Christopher Nolan", "DVD001");

        dvd.setAvailable(false);
        assertTrue(!dvd.isAvailable());

        dvd.setAvailable(true);
        assertTrue(dvd.isAvailable());
    }
}
