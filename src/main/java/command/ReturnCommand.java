package command;

import model.Item;
import model.Patron;

/**
 * Command Pattern:
 * Encapsulates the action of returning a checked-out item so the operation
 * can be executed, undone, logged, or extended later.
 *
 * This command:
 *  - Marks the item available
 *  - Removes the item from the patron's checked-out list
 *
 * Undo reverses the operation:
 *  - Marks the item unavailable again
 *  - Re-adds the item to the patron's checked-out list
 *
 * Note: Observer notifications (e.g., notifying patrons that an item
 * is available) are handled by LibraryCatalog.returnItem(), not here.
 */
public class ReturnCommand implements Command {

    // The item being returned
    private final Item item;

    // The patron returning the item
    private final Patron patron;

    public ReturnCommand(Item item, Patron patron) {
        this.item = item;
        this.patron = patron;
    }

    /**
     * Executes the return operation.
     * Throws an exception if the item is already marked available.
     */
    @Override
    public void execute() {
        if (item.isAvailable()) {
            throw new IllegalStateException(
                "Cannot return \"" + item.getTitle() + "\" — it was not checked out."
            );
        }

        item.setAvailable(true);
        patron.removeCheckedOutItem(item);
    }

    /**
     * Undoes the return operation.
     * Marks the item unavailable and re-adds it to the patron's list.
     */
    @Override
    public void undo() {
        item.setAvailable(false);
        patron.addCheckedOutItem(item);
    }

    public Item getItem() {
        return item;
    }

    public Patron getPatron() {
        return patron;
    }
}
