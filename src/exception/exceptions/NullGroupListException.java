package exception.exceptions;

import exception.Faculty;
import exception.Group;
/**
 * Handles the scenario, when the it is attempted
 *to set the groupList of faculty to null, or access groupList
 *which is null.
 *
 * @author Karine Gevorgyan
 */
public class NullGroupListException extends RuntimeException{
    private String facultyName;

    public NullGroupListException(String facultyName) {
        this.facultyName=facultyName;
    }

    @Override
    public String toString() {
        return "NullGroupListException! Faculty "+facultyName+" doesn't contain any groups!";
    }
}
