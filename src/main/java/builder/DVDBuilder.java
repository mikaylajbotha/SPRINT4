package builder;

import model.DVD;

public class DVDBuilder {

    private String title;
    private String director;
    private String catalogNumber;

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

    public DVD build() {
        if (title == null || director == null || catalogNumber == null) {
            throw new IllegalStateException("title, director, and catalogNumber are required to build a DVD");
        }
        return new DVD(title, director, catalogNumber);
    }
}
