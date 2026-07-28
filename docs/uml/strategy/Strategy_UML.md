# Strategy Pattern — UML Diagram

Used so `MenuSystem` can choose different search behaviors at runtime
(title search, author search, ID search, type search, etc.) without
changing `LibraryCatalog` or duplicating search logic.

```mermaid
classDiagram
    class SearchStrategy {
        <<interface>>
        +search(List~Item~, String) List~Item~
    }

    class SearchByTitle {
        +search(List~Item~, String) List~Item~
    }

    class SearchByAuthor {
        +search(List~Item~, String) List~Item~
    }

    class SearchById {
        +search(List~Item~, String) List~Item~
    }

    class SearchByType {
        +search(List~Item~, String) List~Item~
    }

    class LibraryCatalog {
        -List~Item~ items
        +getItems() List~Item~
        +find(SearchStrategy, String) List~Item~
    }

    class MenuSystem {
        +performSearch() void
    }

    SearchStrategy <|.. SearchByTitle
    SearchStrategy <|.. SearchByAuthor
    SearchStrategy <|.. SearchById
    SearchStrategy <|.. SearchByType

    MenuSystem --> SearchStrategy : selects
    LibraryCatalog --> SearchStrategy : executes
