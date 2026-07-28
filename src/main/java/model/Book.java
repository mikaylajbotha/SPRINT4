package model;

// A Book item that can live in the library catalog
public class Book implements Item {
    // Book's display title
    private String title;
    // Book's author
    private String author;

    // Unique book identifier (ISBN)
    private String isbn;

    // Optional fields, set via BookBuilder (null/0 if not provided)
    private String genre;
    private int publicationYear;

    // Whether the book is currently available to check out
    private boolean available;

    // Creates a new book, available by default (genre/year left unset)
    public Book(String title, String author, String isbn) {
        this(title, author, isbn, null, 0);
    }

    // Full constructor including optional fields, used by BookBuilder
    public Book(String title, String author, String isbn, String genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.publicationYear = publicationYear;
        this.available = true;
    }

     // Returns the book's title
    @Override
    public String getTitle() { return title; }

     // Returns the author's name
    public String getAuthor() { return author; }

    // Returns the book's ISBN as its unique id
    @Override
    public String getId() { return isbn; }

    // Kept for backward compatibility with existing code/tests calling getIsbn()
    public String getIsbn() { return isbn; }

    // Returns the book's genre, or null if not set
    public String getGenre() { return genre; }

    // Returns the book's publication year, or 0 if not set
    public int getPublicationYear() { return publicationYear; }

    // Checks if the book is available
    @Override
    public boolean isAvailable() { return available; }

    // Updates availability status
    @Override
    public void setAvailable(boolean available) { this.available = available; }

    // Identifies this item's type for the UI
    @Override
    public String getType() { return "Book"; }
}