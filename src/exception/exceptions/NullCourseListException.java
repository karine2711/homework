package exception.exceptions;

public class NullCourseListException extends RuntimeException {
    private String studentName="";

    public NullCourseListException(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "NullCourseListException! Student "+studentName+ " doesn't study any courses!";
    }
}
