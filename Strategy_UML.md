# Strategy Pattern — UML Diagram

Used so `MenuSystem` can choose different search behaviors at runtime
(title search, creator search, ID search, etc.) without modifying
`LibraryCatalog` or duplicating search logic.

```mermaid
classDiagram
    class SearchStrategy {
        <<interface>>
        +search(List~Item~, String) List~Item~
    }

    class SearchByTitle {
        +search(List~Item~, String) List~Item~
    }

    class SearchByCreator {
        +search(List~Item~, String) List~Item~
    }

    class SearchById {
        +search(List~Item~, String) List~Item~
    }

    class LibraryCatalog {
        -List~Item~ items
        +getItems() List~Item~
        +search(SearchStrategy, String) List~Item~
    }

    class MenuSystem {
        +performSearch() void
    }

    SearchStrategy <|.. SearchByTitle
    SearchStrategy <|.. SearchByCreator
    SearchStrategy <|.. SearchById

    MenuSystem --> SearchStrategy : selects
    LibraryCatalog --> SearchStrategy : executes
