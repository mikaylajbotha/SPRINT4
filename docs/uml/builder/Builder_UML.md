# Builder Pattern — UML Diagram

Constructs `Book` and `DVD` objects through a fluent, step-by-step interface
instead of large/overloaded constructors. Required and optional fields are set
through fluent setter methods, keeping construction logic separate from the
product classes themselves.

```mermaid
classDiagram
    class BookBuilder {
        -String title
        -String author
        -String isbn
        -String genre
        -int publicationYear
        +BookBuilder()
        +title(String) BookBuilder
        +author(String) BookBuilder
        +isbn(String) BookBuilder
        +genre(String) BookBuilder
        +publicationYear(int) BookBuilder
        +build() Book
    }

    class DVDBuilder {
        -String title
        -String director
        -String catalogNumber
        +DVDBuilder()
        +withTitle(String) DVDBuilder
        +withDirector(String) DVDBuilder
        +withCatalogNumber(String) DVDBuilder
        +build() DVD
    }

    class Book {
        +Book(String, String, String)
        +Book(String, String, String, String, int)
    }

    class DVD {
        +DVD(String, String, String)
    }

    BookBuilder ..> Book : builds
    DVDBuilder ..> DVD : builds
