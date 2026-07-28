# Singleton Pattern — UML Diagram

The `LibraryCatalog` class implements the **Singleton Pattern**, ensuring that the
entire application shares one unified catalog instance. It stores all `Item`
objects, supports lookup by ID, and provides methods for adding and retrieving
items.

```mermaid
classDiagram
    class LibraryCatalog {
        -static LibraryCatalog instance
        -List~Item~ items
        -LibraryCatalog()  // private constructor
        +static getInstance() LibraryCatalog
        +addItem(Item) void
        +getItems() List~Item~
        +findById(String) Item
    }

    class Item {
        <<interface>>
        +getId() String
        +isAvailable() boolean
        +setAvailable(boolean) void
    }

    class Book {
        +Book(String title, String author, String id)
        +getId() String
        +isAvailable() boolean
        +setAvailable(boolean) void
    }

    class DVD {
        +DVD(String title, String director, String id)
        +getId() String
        +isAvailable() boolean
        +setAvailable(boolean) void
    }

    LibraryCatalog --> Item : stores
    Item <|-- Book
    Item <|-- DVD
