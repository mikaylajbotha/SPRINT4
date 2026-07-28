# Observer Pattern — UML Diagram

Used so `Patron` objects can be notified automatically when an `Item` they are
interested in becomes available again.

```mermaid
classDiagram
    class Observer {
        <<interface>>
        +update(Item) void
    }

    class PatronObserver {
        -Patron patron
        +PatronObserver(Patron)
        +update(Item) void
        +getPatron() Patron
    }

    class Subject {
        <<interface>>
        +addObserver(Observer) void
        +removeObserver(Observer) void
        +notifyObservers(Item) void
    }

    class AvailabilityNotifier {
        -List~Observer~ observers
        +AvailabilityNotifier()
        +addObserver(Observer) void
        +removeObserver(Observer) void
        +notifyObservers(Item) void
    }

    class Item {
        <<interface>>
        +isAvailable() boolean
        +setAvailable(boolean) void
        +getId() String
        +getType() String
    }

    class Patron {
        +addCheckedOutItem(Item) void
        +removeCheckedOutItem(Item) void
        +getName() String
    }

    Observer <|.. PatronObserver
    Subject <|.. AvailabilityNotifier

    AvailabilityNotifier --> Observer : notifies
    PatronObserver --> Patron : updates
    AvailabilityNotifier --> Item : monitors
