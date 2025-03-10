package fr.ensai.library;

/**
 * Represents a magazine.
 */
public class Magazine extends Item {

    // Atributes
    private String issn;
    private int issueNumber;

    /**
     * Constructs a new Magazine object.
     */
    public Magazine(String issn, String title, int issueNumber, int year, int pageCount) {
        super(title, year, pageCount);
        this.issn = issn;
        this.issueNumber = issueNumber;
    }

    @Override
    public String toString() {
        return "Magazine " + title;
    }

}
