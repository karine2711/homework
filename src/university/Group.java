package university;

import university.exceptions.NullStudentListException;

import java.text.DecimalFormat;

/**
 * The Group class represents the groups in each faculty of the University.
 * Contains lists of courses and students.
 *
 * @author Karine Gevorgyan
 */
public class Group {

    final static DecimalFormat numberFormat = new DecimalFormat("#.0");
    private String name;
    private Student[] students;

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStudents(Student... students) {
        this.students = students;
    }

    public Student[] getStudents() {
        if (students == null) {
            throw new NullStudentListException(name);
        }
        return students;
    }

    public String[] getStudentNames() {
        int size = getStudents().length;
        String[] studentNames = new String[size];
        for (int i = 0; i < size; i++) {
            studentNames[i] = students[i].getFullName();
        }
        return studentNames;
    }

    public void printStudents() {
        for (Student student : getStudents()) {
            System.out.println("        " + student.getFullName());
            student.printCourseGrades();
        }
    }

    public double countMeanGrade(String courseName) {
        double sum = 0;
        int quantity = 0;
        for (Student student : getStudents()) {
            int index = UniversityService.search(student.getCourses(), courseName);
            if (index != -1) {
                System.out.println(student.getFullName() + ":  " + student.getCourses()[index].getGrade());
                sum += student.getCourses()[index].getGrade();
                quantity++;
            }
        }
        if (quantity == 0) {
            return 0;
        }
        return Double.parseDouble(numberFormat.format(sum / quantity));
    }

}
