package command;

/**
 * The Command interface defines the operations that all concrete
 * command classes must implement: execute an action and undo it.
 */
public interface Command {
    void execute();
    void undo();
}
