package fr.ensai.library;

/**
 * Represents an person.
 */
public abstract class Person {

    // Attributes
    protected String name;
    protected int age;

    /**
     * Constructs a new Person object.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
