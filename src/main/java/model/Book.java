package model;

/**
 * Represents a Book item in the library catalog.
 *
 * Implements the Item interface so it can be used uniformly with other
 * catalog items (DVDs, future media types, etc.).
 *
 * Supports optional fields (genre, publicationYear) via the Builder Pattern.
 */
public class Book implements Item {

    // Required fields
    private String title;
    private String author;
    private String isbn;

    // Optional fields (set via BookBuilder)
    private String genre;
    private int publicationYear;

    // Availability status
    private boolean available;

    /**
     * Minimal constructor (required fields only).
     * Optional fields default to null/0.
     */
    public Book(String title, String author, String isbn) {
        this(title, author, isbn, null, 0);
    }

    /**
     * Full constructor used by BookBuilder.
     */
    public Book(String title, String author, String isbn, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.publicationYear = publicationYear;
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
     * Returns the book's author.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Required by Item interface — creator = author.
     */
    @Override
    public String getCreator() {
        return author;
    }

    /**
     * Returns the book's ISBN as its unique ID.
     */
    @Override
    public String getId() {
        return isbn;
    }

    /**
     * Backward compatibility for older code/tests.
     */
    public String getIsbn() {
        return isbn;
    }

    // -------------------------------------------------------------------------
    // Optional fields
    // -------------------------------------------------------------------------

    public String getGenre() {
        return genre;
    }

    public int getPublicationYear() {
        return publicationYear;
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
        return "Book";
    }
}
