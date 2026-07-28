package builder;

import model.Book;

/**
 * Builder Pattern for constructing Book objects with optional fields.
 * Required fields: title, author, isbn
 * Optional fields: genre, publicationYear
 *
 * This builder allows chained method calls:
 * new BookBuilder()
 *      .title("Example")
 *      .author("Author")
 *      .isbn("12345")
 *      .genre("Fiction")
 *      .publicationYear(2024)
 *      .build();
 */
public class BookBuilder {

    // Required fields
    private String title;
    private String author;
    private String isbn;

    // Optional fields
    private String genre;
    private int publicationYear;

    public BookBuilder() {
        // Empty constructor for fluent builder usage
    }

    /**
     * Sets the title (required)
     */
    public BookBuilder title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Sets the author (required)
     */
    public BookBuilder author(String author) {
        this.author = author;
        return this;
    }

    /**
     * Sets the ISBN (required)
     */
    public BookBuilder isbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    /**
     * Sets the genre (optional)
     */
    public BookBuilder genre(String genre) {
        this.genre = genre;
        return this;
    }

    /**
     * Sets the publication year (optional)
     */
    public BookBuilder publicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
        return this;
    }

    /**
     * Builds the final Book object once all required fields are set.
     * Throws an exception if any required field is missing.
     */
    public Book build() {
        if (title == null || author == null || isbn == null) {
            throw new IllegalStateException(
                "title, author, and isbn are required to build a Book"
            );
        }

        return new Book(title, author, isbn, genre, publicationYear);
    }
}
