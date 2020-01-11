package exception;

/**
 * Represents the courses of the University
 *
 * @author Karine Gevorgyan
 */
public class CourseGrade {
    private String courseName;
    private double grade;


    public CourseGrade(String courseName, double grade) {
        this.courseName = courseName;
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public String getCourseName() {
        return courseName;
    }

}
