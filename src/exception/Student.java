package exception;

import java.text.DecimalFormat;
import java.util.Scanner;

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
    private CourseGrade[] courseGrades;

    public Student(StudentBuilder student) {
        this.fullName = student.fullName;
        this.courseGrades = student.courseGrades;
    }

    public String getFullName() {
        return fullName;
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

    //-----------------------------------------------------------------------------------------
    public static class StudentBuilder {
        private String fullName; //required
        private CourseGrade[] courseGrades = {};

        public StudentBuilder(String fullName, String... courses) {
            this.fullName = fullName;
            for (String course : courses) {
                course(course);
            }
        }

        public StudentBuilder course(String courseName) {
            int index = UniversityService.search(this.courseGrades, courseName);
            if (index == -1) {
                CourseGrade courseGrade = new CourseGrade(courseName);
                courseGrades = DynamicArray.addElement(this.courseGrades, courseGrade);
            }
            return this;
        }

        public StudentBuilder courseGrade(String courseName, double grade) {
            int index;
            index = UniversityService.search(this.courseGrades, courseName);
            if (index == -1) {
                CourseGrade courseGrade = new CourseGrade(courseName, grade);
                courseGrades = DynamicArray.addElement(this.courseGrades, courseGrade);
            } else {
                this.courseGrades[index].setGrade(grade);
            }
            return this;
        }

        public Student build() {
            if (courseGrades.length == 0) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("The student can't be added if he/she doesn't take any course");
                System.out.print("Please enter at least one course for " + fullName);
                System.out.print("Course: ");
                course(scanner.next());
            }
            Student s = new Student(this);
            return s;
        }

    }
}
