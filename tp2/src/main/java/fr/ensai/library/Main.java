package fr.ensai.library;

public class Main {

    public static void main(String[] args) {

        Author tolkien = new Author("J.R.R. Tolkien", 81, "UK");

        Book fellowshipOfTheRing = new Book(
                "978-0-618-26025-6",
                "The Fellowship of the Ring",
                tolkien,
                1954,
                423);

        System.out.println(fellowshipOfTheRing.toString());

        Library librairie = new Library("MaximeBooks");
        librairie.displayItems();
        librairie.loadBooksFromCSV("books.csv");

        Magazine vogue = new Magazine("867-9-507-15914-5", "Vogue 1er ouvrage", 1915, 1953, 0);
        librairie.addMagazine(vogue);
        librairie.displayItems();
    }
}