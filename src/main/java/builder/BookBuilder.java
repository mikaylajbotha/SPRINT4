package builder;

import model.Book;

/**
 * Builder Pattern: constructs a Book step by step through chained calls,
 * so optional fields (genre, publicationYear) don't require a huge constructor.
 */
public class BookBuilder {

    private String title;
    private String author;
    private String isbn;
    private String genre;
    private int publicationYear;

    // Required field
    public BookBuilder title(String title) {
        this.title = title;
        return this;
    }

    // Required field
    public BookBuilder author(String author) {
        this.author = author;
        return this;
    }

    // Required field
    public BookBuilder isbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    // Optional field
    public BookBuilder genre(String genre) {
        this.genre = genre;
        return this;
    }

    // Optional field
    public BookBuilder publicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
        return this;
    }

    // Builds the final Book once all desired fields have been set
    public Book build() {
        if (title == null || author == null || isbn == null) {
            throw new IllegalStateException(
                "title, author, and isbn are required to build a Book"
            );
        }
        return new Book(title, author, isbn, genre, publicationYear);
    }
}
