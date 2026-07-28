package command;

/**
 * Command Pattern:
 * Defines the interface for all command operations in the system.
 *
 * Each command must implement:
 *  - execute(): performs the action
 *  - undo(): reverses the action
 *
 * Concrete commands include:
 *  - CheckoutCommand
 *  - ReturnCommand
 *
 * This abstraction allows commands to be logged, queued, undone,
 * or extended without modifying client code.
 */
public interface Command {

    /**
     * Executes the command's action.
     */
    void execute();

    /**
     * Reverses the command's action.
     */
    void undo();
}
