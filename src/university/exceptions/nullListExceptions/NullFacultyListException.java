package university.exceptions.nullListExceptions;

/**
 * Handles the scenario, when the University is about to
 * be created, but be left without any faculties
 *
 * @author Karine Gevorgyan
 */
public class NullFacultyListException extends NullListException {

    public NullFacultyListException(String universityName) {
        super(String.format("NullFacultyListException! University %s doesn't contain any faculties!", universityName));
    }

    @Override
    public String toString() {
        return this.getMessage();
    }

}
