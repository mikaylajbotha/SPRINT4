import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import builder.DVDBuilder;
import model.DVD;

public class DVDTest {

    // -------------------------------------------------------------------------
    // Constructor Tests
    // -------------------------------------------------------------------------

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

    // -------------------------------------------------------------------------
    // Builder Tests
    // -------------------------------------------------------------------------

    @Test
    public void testBuilderCreatesRequiredFields() {
        DVD dvd = new DVDBuilder()
                .withTitle("Interstellar")
                .withDirector("Christopher Nolan")
                .withCatalogNumber("DVD999")
                .build();

        assertEquals("Interstellar", dvd.getTitle());
        assertEquals("Christopher Nolan", dvd.getDirector());
        assertEquals("DVD999", dvd.getId());
        assertTrue(dvd.isAvailable());
    }

    @Test
    public void testBuilderOptionalFields() {
        DVD dvd = new DVDBuilder()
                .withTitle("The Matrix")
                .withDirector("Wachowski Sisters")
                .withCatalogNumber("DVD777")
                .withGenre("Sci-Fi")
                .withReleaseYear(1999)
                .build();

        assertEquals("Sci-Fi", dvd.getGenre());
        assertEquals(1999, dvd.getReleaseYear());
    }

    @Test
    public void testBuilderOptionalFieldsDefault() {
        DVD dvd = new DVDBuilder()
                .withTitle("The Matrix")
                .withDirector("Wachowski Sisters")
                .withCatalogNumber("DVD777")
                .build();

        assertEquals(null, dvd.getGenre());
        assertEquals(0, dvd.getReleaseYear());
    }
}
