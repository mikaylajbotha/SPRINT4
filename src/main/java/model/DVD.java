package model;

/**
 * Represents a DVD item in the library catalog.
 *
 * Implements the Item interface so DVDs can be treated uniformly with
 * other catalog items (Books, future media types, etc.).
 *
 * Supports optional fields (genre, releaseYear) via the DVDBuilder.
 */
public class DVD implements Item {

    // Required fields
    private String title;
    private String director;
    private String catalogNumber;

    // Optional fields (set via DVDBuilder)
    private String genre;
    private int releaseYear;

    // Availability status
    private boolean available;

    /**
     * Minimal constructor (required fields only).
     * Optional fields default to null/0.
     */
    public DVD(String title, String director, String catalogNumber) {
        this(title, director, catalogNumber, null, 0);
    }

    /**
     * Full constructor used by DVDBuilder.
     */
    public DVD(String title, String director, String catalogNumber,
               String genre, int releaseYear) {

        this.title = title;
        this.director = director;
        this.catalogNumber = catalogNumber;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.available = true;
    }

    // -------------------------------------------------------------------------
    // Item interface implementation
    // -------------------------------------------------------------------------

    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Returns the DVD's director.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Required by Item interface — creator = director.
     */
    @Override
    public String getCreator() {
        return director;
    }

    /**
     * Returns the DVD's catalog number as its unique ID.
     */
    @Override
    public String getId() {
        return catalogNumber;
    }

    // -------------------------------------------------------------------------
    // Optional fields
    // -------------------------------------------------------------------------

    public String getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    // -------------------------------------------------------------------------
    // Availability
    // -------------------------------------------------------------------------

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public void setAvailable(boolean available) {
        this.available = available;
    }

    // -------------------------------------------------------------------------
    // UI / Type identification
    // -------------------------------------------------------------------------

    @Override
    public String getType() {
        return "DVD";
    }
}
