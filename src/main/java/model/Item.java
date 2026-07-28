package model;

/**
 * Shared contract for anything the library catalog can store and manage.
 *
 * Implementations include:
 *  - Book
 *  - DVD
 *  - Future media types (Magazine, Audiobook, etc.)
 *
 * This interface supports:
 *  - Factory Method Pattern (ItemFactory returns Item)
 *  - Strategy Pattern (search uses getCreator(), getTitle(), getId())
 *  - Command Pattern (checkout/return uses isAvailable(), setAvailable())
 *  - Observer Pattern (LibraryCatalog notifies observers when availability changes)
 */
public interface Item {

    /**
     * Unique identifier for the item.
     * Examples:
     *  - Books: ISBN
     *  - DVDs: Catalog number
     */
    String getId();

    /**
     * Human-readable display title.
     */
    String getTitle();

    /**
     * Creator of the item.
     * Examples:
     *  - Books: author
     *  - DVDs: director
     */
    String getCreator();

    /**
     * True if the item is currently available for checkout.
     */
    boolean isAvailable();

    /**
     * Updates the availability status.
     * Used by checkout/return commands and observer notifications.
     */
    void setAvailable(boolean available);

    /**
     * Type label used by the UI.
     * Examples:
     *  - "Book"
     *  - "DVD"
     */
    String getType();
}
