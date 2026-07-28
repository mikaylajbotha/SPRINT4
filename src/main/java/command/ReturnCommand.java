package command;

import model.Item;
import model.Patron;

// Command that returns a checked-out item and updates the patron's record
public class ReturnCommand implements Command {

    // The item being returned
    private final Item item;

    // The patron returning it
    private final Patron patron;

    public ReturnCommand(Item item, Patron patron) {
        this.item = item;
        this.patron = patron;
    }

    // Marks the item available again and removes it from the patron's list
    @Override
    public void execute() {
        if (item.isAvailable()) {
            throw new IllegalStateException(
                "Cannot return \"" + item.getTitle() + "\" — it was not checked out.");
        }
        item.setAvailable(true);
        patron.removeCheckedOutItem(item);
    }

    // Reverses the return: marks item unavailable and re-adds it to the patron
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