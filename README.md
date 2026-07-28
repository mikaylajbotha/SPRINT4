# SE350Project

## Sprint 2

- **Project chosen:** Library Checkout System (CLI-based)
- **Planned Design Patterns:** Singleton, Factory Method, Builder, Observer, Strategy, Command
- **Libraries used:** JUnit 5 (junit-platform-console-standalone)

## Sprint 3

### Design Patterns Implemented

| Design Pattern | Relevant Classes | UML Diagram |
|---|---|---|
| **Singleton** | `catalog.LibraryCatalog` | [Singleton_UML.md](Singleton_UML.md) |
| **Factory Method** | `model.Item`, `model.Book`, `model.DVD`, `factory.ItemFactory`, `factory.BookFactory`, `factory.DVDFactory` | [FactoryMethod_UML.md](FactoryMethod_UML.md) |

- **Singleton** — `LibraryCatalog` was refactored so its constructor is private and
  the only way to obtain it is through `LibraryCatalog.getInstance()`. This
  guarantees the whole application shares one catalog of items rather than each
  class holding its own separate list.
- **Factory Method** — Introduced an `Item` interface implemented by `Book` and a
  new `DVD` class, plus an abstract `ItemFactory` with concrete `BookFactory` and
  `DVDFactory` subclasses. `MenuSystem` now creates catalog items through these
  factories instead of calling `new Book(...)` directly, so new item types can be
  added later without touching existing client code.

### What I want to show for the Final Submission

A command-line Library Checkout System where a user can browse a shared catalog
of items (books and DVDs), check items out, and return them. By the final
submission I plan to have all 6 planned patterns working together: Singleton
(shared catalog), Factory Method (item creation), Builder (constructing complex
`Book`/`DVD` objects with optional fields), Observer (notifying patrons when a
previously checked-out item becomes available again), Strategy (different search
strategies for the catalog, e.g. by title vs. by author), and Command (encapsulating
checkout/return actions so they can be logged or undone). This scope may narrow
depending on time, but the core checkout/return/search flow is the priority.

### Problems / Blockers

- The `Item` interface required refactoring `Book` and `LibraryCatalog`, which had
  already been written against a concrete `Book` type in Sprint 2. This was a small,
  contained refactor, but it's a reminder to design interfaces before implementing
  further patterns (e.g. Builder) so more rework isn't needed later.
- `Patron.java` had an incorrect package declaration (`main.model` instead of
  `model`) left over from an earlier IDE reorganization; fixed to match the rest of
  the project's package structure.
- Command, Observer, and Builder classes exist only as empty placeholders so far —
  no blockers currently identified for implementing them in the next Sprint.