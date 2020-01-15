package exception;

import exception.exceptions.NullStudentListException;

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
    private Student[] studentList;


    public Group(String name) {
        this.name = name;
    }

    public void setStudentList(Student...students){
            this.studentList = students;
    }

    public String getName() {
        return name;
    }

    public Student[] getStudentList() {
        if(studentList==null){
            throw new NullStudentListException(name);
        }
        return studentList;
    }

    public String[] getStudentNames() {
        int size=getStudentList().length;
        String[] studentNames = new String[size];
        for (int i = 0; i <size; i++) {
            studentNames[i] = studentList[i].getFullName();
        }
        return studentNames;
    }

    public void printStudents() {
        for (Student student : getStudentList()) {
            System.out.println("        " + student.getFullName());
            student.printCourseGrades();
        }
    }

    public double countMeanGrade(String courseName) {
        double sum = 0;
        int quantity = 0;
        for (Student student : getStudentList()) {
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
