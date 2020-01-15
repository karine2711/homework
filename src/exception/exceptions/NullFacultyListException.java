package exception.exceptions;

/**
 * Handles the scenario, when the University is about to
 * be created, but be left without any faculties
 *
 * @author Karine Gevorgyan
 */
public class NullFacultyListException extends RuntimeException {
    private String universityName;

    public NullFacultyListException(String univerityName) {
        this.universityName = univerityName;
    }

    @Override
    public String toString() {
        return "NullFacultyListException! University " + universityName + " doesn't contain any faculties!";
    }
}
