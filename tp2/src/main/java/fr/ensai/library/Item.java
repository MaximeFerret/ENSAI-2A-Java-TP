package fr.ensai.library;

/**
 * Represents an item.
 */
public abstract class Item {

    // Attributes
    protected String title;
    protected int year;
    protected int pageCount;

    /**
     * Constructs a new Item object.
     */
    public Item(String title, int year, int pageCount) {
        this.title = title;
        this.year = year;
        this.pageCount = pageCount;
    }
}