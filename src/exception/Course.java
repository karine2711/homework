package exception;

/**
 * Represents the courses of the University
 *
 * @author Karine Gevorgyan
 */

public class Course {
    private String courseName;
    private double grade = 0;

    public Course(String courseName, double grade) {
        this.courseName = courseName;
        this.grade = grade;
    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getCourseName() {
        return courseName;
    }

}
