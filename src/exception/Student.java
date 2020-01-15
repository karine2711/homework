package exception;

import java.text.DecimalFormat;
import java.util.Random;

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
    private Course[] courses;

    private Student(StudentBuilder student) {
        this.fullName = student.fullName;
        this.courses = student.courses;
    }

    public String getFullName() {
        return fullName;
    }

    public void setGrade(String courseName, double grade) {
        int index;
        index = UniversityService.search(this.courses, courseName);
        if (index == -1) {
            System.out.println("The student doesn't study course named " + courseName);
        } else if (grade <= 0 || grade > 10) {
            System.out.println("The grade must be in the range (0,10]. Given grade " + grade);
        } else {
            this.courses[index].setGrade(grade);
        }
    }

    public Course[] getCourses() {
        return courses;
    }

    public void printCourseGrades() {

        for (Course course : this.courses) {
            System.out.println("            " + course.getCourseName() + ":  " + course.getGrade());
        }
    }

    private void setCourses(Course...courses) {
       this.courses=courses;
    }

    public void gradeStudentRandomly() {
        Random rnd = new Random();
        for (Course course : courses) {
            if (course.getGrade() == 0) {
                double temp = Double.parseDouble(numberFormat.format(rnd.nextDouble() * 9 + 1));
                course.setGrade(temp);
            }
        }
    }

    public double countMeanGrade() {
        int quantity = courses.length;
        double sum = 0;
        for (Course course : courses) {
            sum += course.getGrade();
        }
        return Double.parseDouble(numberFormat.format(sum / quantity));
    }

    //-----------------------------------------------------------------------------------------
    //StudentBuilder Class
    public static class StudentBuilder {

        private String fullName; //required
        private Course[] courses = {};
        private String address;
        private String phone;
        private String email;

        public StudentBuilder(String fullName) {
            this.fullName = fullName;
        }

        public StudentBuilder address(String address){
            this.address=address;
            return this;
        }

        public StudentBuilder phone(String phone){
            this.phone=phone;
            return this;
        }

        public StudentBuilder email(String email){
            this.email=email;
            return this;
        }

        public Student build() {
            Student s = new Student(this);
            return s;
        }

    }

}
