package exception.exceptions;

public class NullStudentListException extends RuntimeException {
    private String groupName;

    public NullStudentListException(String groupName) {
        this.groupName=groupName;
    }

    @Override
    public String toString() {
        return "Error! Group "+groupName+" doesn't contain any students!";
    }
}
