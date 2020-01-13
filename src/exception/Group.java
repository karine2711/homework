package exception;

import javax.xml.transform.sax.SAXResult;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * The Group class represents the groups in each faculty of the University.
 * Contains lists of courses and students.
 *
 * @author Karine Gevorgyan
 */
public class Group {
    final static DecimalFormat numberFormat = new DecimalFormat("#.0");
    private String name;
    private Student[] studentList = {};


    public Group(String name, Student... students) {
        this.name = name;
        if (students.length == 0) {
            System.out.println("A group cannot be created without students");
            this.studentList = DefaultHandler.studentListCreator();
        } else {
            for (Student student : students) {
                this.studentList = DynamicArray.addElement(studentList, student);
            }
        }
    }

    public String getName() {
        return name;
    }

    public Student[] getStudentList() {
        return studentList;
    }

    public void printStudents() {
        for (Student student : studentList) {
            System.out.println(student.getFullName());
        }
    }

    public String[] getStudentNames() {
        String[] studentNames = new String[studentList.length];
        for (int i = 0; i < studentList.length; i++) {
            studentNames[i] = studentList[i].getFullName();
        }
        return studentNames;
    }

    //    public double countMeanGrade(String courseName) {
//        int courseIndex = UniversityService.search(courseNames, courseName);
//        if (courseIndex == -1) {
//            return -1;
//        }
//
//        int quantity = studentList.length;
//        double sum = 0;
//        System.out.println(courseName);
//        for (Student student : studentList) {
//            System.out.println(student.getFullName() + "':  " + student.getCourseGrades()[courseIndex].getGrade());
//            sum += student.getCourseGrades()[courseIndex].getGrade();
//        }
//
//        return Double.parseDouble(numberFormat.format(sum / quantity));
//    }
}
