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
            System.out.println("        "+student.getFullName());
            student.printCourseGrades();
        }
    }

    public String[] getStudentNames() {
        String[] studentNames = new String[studentList.length];
        for (int i = 0; i < studentList.length; i++) {
            studentNames[i] = studentList[i].getFullName();
        }
        return studentNames;
    }

        public double countMeanGrade(String courseName) {
            System.out.println(courseName);
       double sum=0;
       int quantity=0;
        for(Student student:studentList){
            int index=UniversityService.search(student.getCourseGrades(),courseName);
            if(index!=-1){
                System.out.println(student.getFullName()+":  "+student.getCourseGrades()[index].getGrade());
                sum+=student.getCourseGrades()[index].getGrade();
                quantity++;
            }
        }
        if(quantity==0){
            return 0;
        }
        return Double.parseDouble(numberFormat.format(sum / quantity));
    }
}
