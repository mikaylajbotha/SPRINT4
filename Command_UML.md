# Command Pattern — UML Diagram

Encapsulates checkout and return actions as command objects, allowing
`MenuSystem` (the invoker) to trigger operations without knowing the internal
logic of how items are checked out or returned. Commands modify the state of
`Item` and `Patron` (the receivers).

```mermaid
classDiagram
    class Command {
        <<interface>>
        +execute() void
        +undo() void
    }

    class CheckoutCommand {
        -Item item
        -Patron patron
        +CheckoutCommand(Item, Patron)
        +execute() void
        +undo() void
        +getItem() Item
        +getPatron() Patron
    }

    class ReturnCommand {
        -Item item
        -Patron patron
        +ReturnCommand(Item, Patron)
        +execute() void
        +undo() void
        +getItem() Item
        +getPatron() Patron
    }

    class MenuSystem {
        +checkoutItem() void
        +returnItem() void
        +addItem() void
        +printCatalog() void
    }

    class Item {
        <<interface>>
        +isAvailable() boolean
        +setAvailable(boolean) void
    }

    class Patron {
        +addCheckedOutItem(Item) void
        +removeCheckedOutItem(Item) void
    }

    Command <|.. CheckoutCommand
    Command <|.. ReturnCommand

    MenuSystem --> CheckoutCommand : creates & invokes
    MenuSystem --> ReturnCommand : creates & invokes

    CheckoutCommand --> Item : modifies
    CheckoutCommand --> Patron : modifies

    ReturnCommand --> Item : modifies
    ReturnCommand --> Patron : modifies
