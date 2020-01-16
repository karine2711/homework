package university.exceptions.nullListExceptions;

/**
 * Handles the scenario, when the it is attempted
 * to set the groupList of faculty to null, or access groupList
 * which is null.
 *
 * @author Karine Gevorgyan
 */
public class NullGroupListException extends NullListException {

    public NullGroupListException(String facultyName) {
        super(String.format("NullGroupListException! Faculty %s doesn't contain any groups!", facultyName));
    }

    @Override
    public String toString() {
        return this.getMessage();
    }

}
