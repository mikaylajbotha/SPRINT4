# Factory Method Pattern — UML Diagram

The Factory Method pattern allows `MenuSystem` and `LibraryCatalog` to create
`Item` objects (`Book`, `DVD`, …) without knowing which concrete class is being
instantiated. Each concrete factory encapsulates the creation logic for a
specific item type.

```mermaid
classDiagram
    class Item {
        <<interface>>
        +getId() String
        +isAvailable() boolean
        +setAvailable(boolean) void
        +getType() String
    }

    class Book {
        -String title
        -String author
        -String isbn
        -boolean available
        +Book(String title, String author, String isbn)
        +Book(String title, String author, String isbn, String genre, int publicationYear)
        +getTitle() String
        +getAuthor() String
        +getId() String
        +isAvailable() boolean
        +setAvailable(boolean) void
        +getType() String
    }

    class DVD {
        -String title
        -String director
        -String catalogNumber
        -boolean available
        +DVD(String title, String director, String catalogNumber)
        +getTitle() String
        +getDirector() String
        +getId() String
        +isAvailable() boolean
        +setAvailable(boolean) void
        +getType() String
    }

    class ItemFactory {
        <<interface>>
        +createItem(String title, String creator, String id) Item
    }

    class BookFactory {
        +createItem(String title, String creator, String id) Item
    }

    class DVDFactory {
        +createItem(String title, String creator, String id) Item
    }

    Item <|.. Book
    Item <|.. DVD

    ItemFactory <|.. BookFactory
    ItemFactory <|.. DVDFactory

    BookFactory ..> Book : creates
    DVDFactory ..> DVD : creates
