package builder;

import model.DVD;

/**
 * Builder Pattern: constructs DVD objects.
 * Optional fields (genre, releaseYear) are currently ignored
 * because DVD does not define setters for them.
 */
public class DVDBuilder {

    private String title;
    private String director;
    private String catalogNumber;
    private String genre;      // optional, not applied to DVD yet
    private int releaseYear;   // optional, not applied to DVD yet

    public DVDBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public DVDBuilder withDirector(String director) {
        this.director = director;
        return this;
    }

    public DVDBuilder withCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
        return this;
    }

    public DVDBuilder withGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public DVDBuilder withReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public DVD build() {
        // DVD currently only supports title, director, id/catalogNumber
        return new DVD(title, director, catalogNumber);
    }
}
