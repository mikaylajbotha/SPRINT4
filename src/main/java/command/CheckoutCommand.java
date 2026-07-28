package command;

import model.Item;
import model.Patron;

// Command that checks out an item and records it against a patron
public class CheckoutCommand implements Command {

    // The item being checked out
    private final Item item;

    // The patron checking it out
    private final Patron patron;

    public CheckoutCommand(Item item, Patron patron) {
        this.item = item;
        this.patron = patron;
    }

    @Override
    public void execute() {
        if (!item.isAvailable()) {
            throw new IllegalStateException(
                "Cannot check out \"" + item.getTitle() + "\" — it is not available.");
        }
        item.setAvailable(false);
        patron.addCheckedOutItem(item);
    }

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