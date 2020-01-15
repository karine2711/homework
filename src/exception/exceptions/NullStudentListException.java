package exception.exceptions;

public class NullStudentListException extends Exception {
    public NullStudentListException() {
    }

    @Override
    public String toString() {
        return "Error! No student in the group";
    }
}
