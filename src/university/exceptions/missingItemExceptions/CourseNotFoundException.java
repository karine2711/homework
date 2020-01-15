package university.exceptions.missingItemExceptions;

public class CourseNotFoundException extends ItemNotFoundException {
    String courseName;
    String studentName;

    public CourseNotFoundException(String courseName, String studentName) {
        this.courseName = courseName;
        this.studentName = studentName;
    }

    @Override
    public String toString() {
        return "Student " + studentName + " doesn't take " + courseName;
    }
}
