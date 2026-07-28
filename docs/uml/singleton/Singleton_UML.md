# Singleton Pattern — UML Diagram

Applied to `LibraryCatalog` so the entire application shares exactly one
catalog instance.

```mermaid
classDiagram
    class LibraryCatalog {
        -static LibraryCatalog instance
        -List~Item~ items
        -LibraryCatalog()
        +static getInstance() LibraryCatalog
        +addItem(Item) void
        +getItems() List~Item~
        +findById(String) Item
    }
