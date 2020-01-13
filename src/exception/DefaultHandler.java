package exception;

/**
 * Adds default values to null objects.
 *
 * @author Karine Gevorgyan
 */
public class DefaultHandler {
    public static void setDefaultGroupList(Faculty faculty) {
        faculty.setGroups(new Group[]{new Group('A')});
    }
    public static void setDefaultCourseList(Student.StudentBuilder student) {
        student.course("Armenian");
    }
}
