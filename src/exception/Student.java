package exception;

import java.text.DecimalFormat;

/**
 * The Student class represents the students of the university.
 * Contains lists of courseGrades and relevant information about
 * the student.
 *
 * @author Karine Gevorgyan
 */
public class Student {
    final static DecimalFormat numberFormat = new DecimalFormat("#.0");
    private String fullName;
    private char groupName;
    private String facultyName;
    private int groupIndex;
    private CourseGrade[] courseGrades;

    public Student(String fullName,String facultyName, char groupName) {
        this.fullName = fullName;
        this.groupName = groupName;
        this.facultyName = facultyName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public char getGroupName() {
        return groupName;
    }

    public void setGroupIndex(int index) {
        this.groupIndex = index;
    }

    public int getGroupIndex() {
        return groupIndex;
    }

    public CourseGrade[] getCourseGrades() {
        return courseGrades;
    }

    public void setCourseGrades(CourseGrade[] courseGrades) {
        this.courseGrades = courseGrades;
    }

    public void printCourseGrades() {
        System.out.println("--" + this.getFullName() + "--");
        for (CourseGrade courseGrade : this.courseGrades) {
            System.out.println(courseGrade.getCourseName() + ":  " + courseGrade.getGrade());
        }
    }

    public double countMeanGrade() {
        int quantity = courseGrades.length;
        double sum = 0;
        for (CourseGrade courseGrade : courseGrades) {
            sum += courseGrade.getGrade();
        }
        return Double.parseDouble(numberFormat.format(sum / quantity));
    }
}
