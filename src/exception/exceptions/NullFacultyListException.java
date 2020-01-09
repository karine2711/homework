package exception.exceptions;
/**
 * Handles the scenario, when the University is about to
 * be created, but be left without any faculties
 *
 *
 * @author Karine Gevorgyan
 */
public class NullFacultyListException extends Exception {

    public NullFacultyListException() {

    }

    @Override
    public String toString() {
        return "Error! No faculty in the University!";
    }
}
