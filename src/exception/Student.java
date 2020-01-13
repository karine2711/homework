package exception;

import java.text.DecimalFormat;
import java.util.Random;
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

    public void setGrade(String courseName, double grade) {
        int index;
        index = UniversityService.search(this.courseGrades, courseName);
        if (index == -1) {
            System.out.println("The student doesn't study course named " + courseName);
        } else if (grade <= 0 || grade > 10) {
            System.out.println("The grade must be in the range (0,10]. Given grade " + grade);
        } else {
            this.courseGrades[index].setGrade(grade);
        }
    }

    public CourseGrade[] getCourseGrades() {
        return courseGrades;
    }

    public void printCourseGrades() {

        for (CourseGrade courseGrade : this.courseGrades) {
            System.out.println("            " + courseGrade.getCourseName() + ":  " + courseGrade.getGrade());
        }
    }

    public void gradeStudentRandomly() {
        Random rnd = new Random();
        for (CourseGrade courseGrade : courseGrades) {
            if (courseGrade.getGrade() == 0) {
                double temp = Double.parseDouble(numberFormat.format(rnd.nextDouble() * 9 + 1));
                courseGrade.setGrade(temp);
            }
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
    //StudentBuilder Class
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
                courseGrades = DefaultHandler.courseListCreator();
            }
            Student s = new Student(this);
            return s;
        }

    }
}
