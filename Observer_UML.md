# Observer Pattern — UML Diagram

Used so `Patron` objects can be notified automatically when an `Item` they are
interested in becomes available again. `AvailabilityNotifier` acts as the
subject, while `PatronObserver` is the concrete observer that updates a patron.

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
        +getId() String
        +isAvailable() boolean
        +setAvailable(boolean) void
    }

    class Patron {
        -String name
        -String id
        +getName() String
        +addCheckedOutItem(Item) void
        +removeCheckedOutItem(Item) void
    }

    Observer <|.. PatronObserver
    Subject <|.. AvailabilityNotifier

    AvailabilityNotifier --> Observer : notifies
    PatronObserver --> Patron : updates
    AvailabilityNotifier --> Item : monitors
