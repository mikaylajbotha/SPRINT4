package model;

// Shared contract for anything the catalog can hold and check out/return
// Book, DVD, Magazine, etc. ItemFactory subclasses return this type.
public interface Item {

    // Unique identifier (ISBN for books, catalog # for DVDs, etc.)
    String getId();

    // Item's display title
    String getTitle();

    // True if the item can currently be checked out
    boolean isAvailable();

    // Marks the item as checked out or returned
    void setAvailable(boolean available);

    // Type label used by the UI (e.g. "Book", "DVD")
    String getType();
}