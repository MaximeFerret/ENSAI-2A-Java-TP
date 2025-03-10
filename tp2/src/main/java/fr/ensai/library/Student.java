package fr.ensai.library;

/**
 * Represents a student.
 */
public class Student extends Person {
    // Atributes
    private int academicYear;
    private boolean isClassDelegate;

    /**
     * Constructs a new Studet object.
     */
    public Student(String name, int age, int academicYear, boolean isClassDelegate) {
        super(name, age);
        this.academicYear = academicYear;
        this.isClassDelegate = isClassDelegate;
    }
}
