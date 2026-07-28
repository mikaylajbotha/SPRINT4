# MenuSystem — UML Diagram

The `MenuSystem` class acts as the main user interface controller for the library
application. It coordinates user actions, delegates object creation to factories,
invokes commands for checkout/return operations, and interacts with the
`LibraryCatalog` singleton to manage items.

```mermaid
classDiagram
    class MenuSystem {
        +MenuSystem()
        +start() void
        +addItem() void
        +checkoutItem() void
        +returnItem() void
        +printCatalog() void
    }

    class LibraryCatalog {
        -static LibraryCatalog instance
        -List~Item~ items
        +getInstance() LibraryCatalog
        +addItem(Item) void
        +findById(String) Item
        +getItems() List~Item~
    }

    class ItemFactory {
        <<interface>>
        +createItem(String title, String creator, String id) Item
    }

    class BookFactory {
        +createItem(String title, String author, String isbn) Item
    }

    class DVDFactory {
        +createItem(String title, String director, String catalogNumber) Item
    }

    class CheckoutCommand {
        -Item item
        -Patron patron
        +CheckoutCommand(Item, Patron)
        +execute() void
        +undo() void
    }

    class ReturnCommand {
        -Item item
        -Patron patron
        +ReturnCommand(Item, Patron)
        +execute() void
        +undo() void
    }

    class Patron {
        -String name
        -String id
        +Patron(String name, String id)
        +addCheckedOutItem(Item) void
        +removeCheckedOutItem(Item) void
        +getCheckedOutItems() List~Item~
    }

    class Item {
        <<interface>>
        +getId() String
        +isAvailable() boolean
        +setAvailable(boolean) void
    }

    MenuSystem --> LibraryCatalog : uses (singleton)
    MenuSystem --> BookFactory : creates books
    MenuSystem --> DVDFactory : creates DVDs

    MenuSystem --> CheckoutCommand : invokes
    MenuSystem --> ReturnCommand : invokes

    CheckoutCommand --> Item : modifies
    CheckoutCommand --> Patron : modifies

    ReturnCommand --> Item : modifies
    ReturnCommand --> Patron : modifies
