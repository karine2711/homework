package university.exceptions.nullListExceptions;

public class NullCourseListException extends NullListException {
    private String studentName = "";

    public NullCourseListException(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "NullCourseListException! Student " + studentName + " doesn't study any courses!";
    }
}
