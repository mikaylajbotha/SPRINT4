package model;

// A DVD item that can live in the library catalog
public class DVD implements Item {
    // DVD's display title
    private String title;
    // DVD's director
    private String director;

    // Unique catalog identifier for the DVD
    private String catalogNumber;

    // Whether the DVD is currently available to check out
    private boolean available;

    // Creates a new DVD, available by default
    public DVD(String title, String director, String catalogNumber) {
        this.title = title;
        this.director = director;
        this.catalogNumber = catalogNumber;
        this.available = true;
    }

    // Returns the DVD's title
    @Override
    public String getTitle() { return title; }

    // Returns the director's name
    public String getDirector() { return director; }

    // Returns the DVD's catalog number as its unique id
    @Override
    public String getId() { return catalogNumber; }

    // Checks if the DVD is available
    @Override
    public boolean isAvailable() { return available; }

    // Updates availability status
    @Override
    public void setAvailable(boolean available) { this.available = available; }

    // Identifies this item's type for the UI
    @Override
    public String getType() { return "DVD"; }
}