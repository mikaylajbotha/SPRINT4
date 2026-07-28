package ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import builder.BookBuilder;
import builder.DVDBuilder;

import catalog.LibraryCatalog;

import command.CheckoutCommand;
import command.Command;
import command.ReturnCommand;

import factory.BookFactory;
import factory.DVDFactory;
import factory.ItemFactory;

import model.Item;
import model.Patron;

import observer.AvailabilityNotifier;
import observer.PatronNotification;

import strategy.SearchByTitle;
import strategy.SearchByCreator;
import strategy.SearchById;

/**
 * Command-line menu loop for the Library Checkout System.
 */
public class MenuSystem {

    private final LibraryCatalog catalog = LibraryCatalog.getInstance();
    private final AvailabilityNotifier notifier = new AvailabilityNotifier();
    private final Map<String, Patron> patrons = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    private void seedCatalog() {
        ItemFactory bookFactory = new BookFactory();
        ItemFactory dvdFactory = new DVDFactory();

        catalog.addItem(bookFactory.createItem("Siddhartha", "Hermann Hesse", "0345339681"));
        catalog.addItem(dvdFactory.createItem("Aquamarine", "Elizabeth Allen Rosenbaum", "DVD-1001"));
    }

    public void start() {
        seedCatalog();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Library Checkout System ---");
            System.out.println("1. Checkout item");
            System.out.println("2. Return item");
            System.out.println("3. Search catalog");
            System.out.println("4. Add new item");
            System.out.println("5. Register for notifications");
            System.out.println("6. Print catalog");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> checkoutItem();
                case "2" -> returnItem();
                case "3" -> searchCatalog();
                case "4" -> addItem();
                case "5" -> registerForNotifications();
                case "6" -> printCatalog();
                case "7" -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }

        System.out.println("Goodbye!");
    }

    private void checkoutItem() {
        Item item = promptForItem();
        if (item == null) return;

        Patron patron = promptForPatron();

        Command command = new CheckoutCommand(item, patron);
        try {
            command.execute();
            System.out.println("Checked out \"" + item.getTitle() + "\" to " + patron.getName() + ".");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private void returnItem() {
        Item item = promptForItem();
        if (item == null) return;

        Patron patron = promptForPatron();

        Command command = new ReturnCommand(item, patron);
        try {
            command.execute();
            System.out.println("Returned \"" + item.getTitle() + "\".");

            notifier.notifyAvailable(item);

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    private Item promptForItem() {
        System.out.print("Enter item id: ");
        String id = scanner.nextLine();

        Item item = catalog.findById(id);
        if (item != null) return item;

        System.out.println("No item found with id \"" + id + "\".");
        return null;
    }

    private Patron promptForPatron() {
        System.out.print("Enter patron id: ");
        String id = scanner.nextLine();

        if (patrons.containsKey(id)) {
            return patrons.get(id);
        }

        System.out.print("New patron - enter name: ");
        String name = scanner.nextLine();
        Patron patron = new Patron(name, id);
        patrons.put(id, patron);
        return patron;
    }

    private void addItem() {
        System.out.print("Add (1) Book or (2) DVD? ");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();
            System.out.print("Genre (optional): ");
            String genre = scanner.nextLine();
            System.out.print("Publication year (optional, 0 to skip): ");
            String yearInput = scanner.nextLine();
            int year = yearInput.isBlank() ? 0 : Integer.parseInt(yearInput);

            BookBuilder builder = new BookBuilder()
                    .title(title)
                    .author(author)
                    .isbn(isbn);

            if (!genre.isBlank()) builder.genre(genre);
            if (year != 0) builder.publicationYear(year);

            catalog.addItem(builder.build());
            System.out.println("Book added.");

        } else if (choice.equals("2")) {
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Director: ");
            String director = scanner.nextLine();
            System.out.print("Catalog number: ");
            String catalogNumber = scanner.nextLine();

            DVDBuilder builder = new DVDBuilder()
                    .withTitle(title)
                    .withDirector(director)
                    .withCatalogNumber(catalogNumber);

            catalog.addItem(builder.build());
            System.out.println("DVD added.");

        } else {
            System.out.println("Invalid option.");
        }
    }

    private void searchCatalog() {
        System.out.println("\nSearch by:");
        System.out.println("1. Title");
        System.out.println("2. Creator");
        System.out.println("3. ID");
        System.out.print("Choose: ");

        String choice = scanner.nextLine();
        System.out.print("Enter search query: ");
        String query = scanner.nextLine();

        List<Item> results = switch (choice) {
            case "1" -> catalog.search(new SearchByTitle(), query);
            case "2" -> catalog.search(new SearchByCreator(), query);
            case "3" -> catalog.search(new SearchById(), query);
            default -> {
                System.out.println("Invalid search type.");
                yield List.of();
            }
        };

        if (results.isEmpty()) {
            System.out.println("No items found.");
        } else {
            System.out.println("\n--- Search Results ---");
            for (Item item : results) {
                String status = item.isAvailable() ? "Available" : "Checked out";
                System.out.println("[" + item.getType() + "] " + item.getTitle()
                        + " (id: " + item.getId() + ") - " + status);
            }
        }
    }

    private void registerForNotifications() {
        System.out.print("Enter patron id: ");
        String id = scanner.nextLine();

        Patron patron = patrons.get(id);
        if (patron == null) {
            System.out.print("New patron - enter name: ");
            String name = scanner.nextLine();
            patron = new Patron(name, id);
            patrons.put(id, patron);
        }

        notifier.addObserver(new PatronNotification(patron));
        System.out.println("Patron registered for notifications.");
    }

    private void printCatalog() {
        List<Item> items = catalog.getItems();
        System.out.println("\n--- Catalog (" + items.size() + " items) ---");
        for (Item item : items) {
            String status = item.isAvailable() ? "Available" : "Checked out";
            System.out.println("[" + item.getType() + "] " + item.getTitle()
                    + " (id: " + item.getId() + ") - " + status);
        }
    }

    public static void main(String[] args) {
        new MenuSystem().start();
    }
}
