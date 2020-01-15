package university.exceptions.nullListExceptions;

public class NullStudentListException extends NullListException {
    private String groupName;

    public NullStudentListException(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "NullStudentListException! Group " + groupName + " doesn't contain any students!";
    }
}
