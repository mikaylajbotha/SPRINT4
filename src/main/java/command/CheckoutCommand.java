package command;

import model.Item;
import model.Patron;

/**
 * Command Pattern:
 * Encapsulates the action of checking out an item so the operation
 * can be executed, undone, logged, or extended later.
 *
 * This command:
 *  - Marks the item unavailable
 *  - Adds the item to the patron's checked-out list
 *
 * Undo reverses the operation:
 *  - Marks the item available again
 *  - Removes the item from the patron's checked-out list
 */
public class CheckoutCommand implements Command {

    // The item being checked out
    private final Item item;

    // The patron performing the checkout
    private final Patron patron;

    public CheckoutCommand(Item item, Patron patron) {
        this.item = item;
        this.patron = patron;
    }

    /**
     * Executes the checkout operation.
     * Throws an exception if the item is already checked out.
     */
    @Override
    public void execute() {
        if (!item.isAvailable()) {
            throw new IllegalStateException(
                "Cannot check out \"" + item.getTitle() + "\" — it is not available."
            );
        }

        item.setAvailable(false);
        patron.addCheckedOutItem(item);
    }

    /**
     * Undoes the checkout operation.
     * Marks the item available and removes it from the patron's list.
     */
    @Override
    public void undo() {
        item.setAvailable(true);
        patron.removeCheckedOutItem(item);
    }

    public Item getItem() {
        return item;
    }

    public Patron getPatron() {
        return patron;
    }
}
