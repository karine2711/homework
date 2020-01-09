package exception.exceptions;

public class NullFacultyListException extends Exception {
    public NullFacultyListException() {

    }

    @Override
    public String toString() {
        return "Error! No faculty in the University!";
    }
}
