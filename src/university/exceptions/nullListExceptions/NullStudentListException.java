package university.exceptions.nullListExceptions;

public class NullStudentListException extends NullListException {

    public NullStudentListException(String groupName) {
        super(String.format("NullStudentListException! Group %s doesn't contain any students!", groupName));
    }

    @Override
    public String toString() {
        return this.getMessage();
    }

}
