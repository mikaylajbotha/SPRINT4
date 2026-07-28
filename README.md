# SE350Project — Library Checkout System (CLI-Based)

This project is a command-line Library Checkout System designed to demonstrate
object‑oriented design, modular architecture, and the implementation of **six
custom design patterns** as required for the SE350 Final Submission.

---

## Sprint 2

- **Project chosen:** Library Checkout System (CLI-based)
- **Planned Design Patterns:** Singleton, Factory Method, Builder, Observer, Strategy, Command
- **Libraries used:** JUnit 5 (junit-platform-console-standalone)
- **Repository:** https://github.com/mikaylajbotha/SPRINT4

---

## Sprint 3

### Design Patterns Implemented (Sprint 3)

| Design Pattern | Relevant Classes | UML Diagram |
|---|---|---|
| **Singleton** | `catalog.LibraryCatalog` | [Singleton_UML.md](Singleton_UML.md) |
| **Factory Method** | `model.Item`, `model.Book`, `model.DVD`, `factory.ItemFactory`, `factory.BookFactory`, `factory.DVDFactory` | [Factory_UML.md](Factory_UML.md) |

#### Summary

- **Singleton** — `LibraryCatalog` now enforces a single shared catalog instance using a private constructor and `getInstance()`.
- **Factory Method** — Introduced `Item` interface, `Book` and `DVD` implementations, and concrete factories to allow extensible item creation.

---

## Sprint 4

### Additional Design Patterns Implemented (Sprint 4)

| Design Pattern | Relevant Classes | UML Diagram |
|---|---|---|
| **Builder** | `builder.BookBuilder`, `builder.DVDBuilder` | [Builder_UML.md](Builder_UML.md) |
| **Command** | `command.Command`, `command.CheckoutCommand`, `command.ReturnCommand` | [Command_UML.md](Command_UML.md) |
| **Observer** | `observer.Observer`, `observer.PatronObserver`, `observer.AvailabilityNotifier` | [Observer_UML.md](Observer_UML.md) |
| **Strategy** | `strategy.SearchStrategy`, `strategy.SearchByTitle`, `strategy.SearchByCreator`, `strategy.SearchById` | [Strategy_UML.md](Strategy_UML.md) |
| **Catalog** | `catalog.LibraryCatalog` | [Catalog_UML.md](Catalog_UML.md) |
| **Menu System** | `ui.MenuSystem` | [MenuSystem_UML.md](MenuSystem_UML.md) |

#### Summary

- **Builder** — Provides fluent construction of `Book` and `DVD` objects. `BookBuilder` supports optional fields; `DVDBuilder` supports required fields only.
- **Command** — Encapsulates checkout/return actions, allowing future undo/logging extensions.
- **Observer** — Patrons can subscribe to notifications when checked-out items become available.
- **Strategy** — Multiple search strategies (title, creator, ID) allow flexible catalog queries.
- **Catalog** — Centralized Singleton catalog storing all items.
- **Menu System** — CLI interface coordinating factories, commands, and catalog operations.

---

## Final Submission Goal

By the final submission, the project will demonstrate:

- A working CLI Library Checkout System
- A shared catalog (Singleton)
- Flexible item creation (Factory Method)
- Configurable item construction (Builder)
- Encapsulated checkout/return actions (Command)
- Patron notifications when items become available (Observer)
- Multiple search strategies for catalog lookup (Strategy)

The final demo will show:

- Browsing catalog items  
- Checking out items  
- Returning items  
- Observer notifications  
- Searching using different strategies  
- A clean, modular architecture using **six custom design patterns**

---

## Problems / Blockers

### Sprint 3 Blockers
- Refactoring required after introducing `Item` interface.
- Incorrect package declaration in `Patron.java` caused compilation issues.
- PowerShell required compiling all Java files at once due to dependency visibility.

### Sprint 4 Blockers
- Observer pattern required adding `AvailabilityNotifier` and integrating observer registration.
- Strategy pattern required restructuring search logic and adding missing strategy classes.
- UML diagrams needed reorganizing to meet rubric requirements (must be in root folder).
- README links needed correction after folder restructuring.
- DVDBuilder required adjustments because the `DVD` class does not support optional fields.

---

## Design Patterns Implemented (All Sprints)

1. **Singleton** — Shared catalog instance  
2. **Factory Method** — Extensible item creation  
3. **Builder** — Fluent object construction  
4. **Command** — Encapsulated checkout/return actions  
5. **Observer** — Patron notifications  
6. **Strategy** — Multiple search strategies  

All UML diagrams for these patterns are included in the **root folder**, as required.



## Final Submission Requirements Checklist

### ✔ Completed
- 6 custom design patterns  
- UML diagrams for all patterns  
- CLI program with working menu  
- README updated for all sprints  
- Patterns integrated into real functionality
- (SE450 only) JUnit tests with 70% coverage  

### ❗ Still Required (Final Submission)
- Final video demo (5–10 minutes)


---

## Bugs / Known Issues

- Some search strategies may return multiple matches; future improvement: ranking results.
- Observer notifications currently print to console; future improvement: queue or log notifications.
- Undo functionality for Command pattern not yet implemented.

---

## Notes

This project demonstrates modular design, extensibility, and maintainability
through the use of six design patterns. The final submission will include a
video walkthrough and any remaining refinements.
