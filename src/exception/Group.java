package exception;

import javax.xml.transform.sax.SAXResult;
import java.text.DecimalFormat;

/**
 * The Group class represents the groups in each faculty of the University.
 * Contains lists of courses and students.
 *
 *
 * @author Karine Gevorgyan
 */
public class Group {
    final static DecimalFormat numberFormat = new DecimalFormat("#.0");
    private char name;
    private String courseNames[];
    private Student[] studentList;
    private  int studentQuantity=0;
    private String[] studentNames;

    public Group(char name, String[] courseNames){
        this.name=name;
        this.courseNames=courseNames;
    }

    public char getName(){return name;}

    public int getStudentQuantity() {
        return studentQuantity;
    }

    public void setStudentQuantity(int studentQuantity) {
        this.studentQuantity = studentQuantity;
    }

    public Student[] getStudentList() {
        return studentList;
    }

    public void setStudentList(Student[] studentList) {
        this.studentList = studentList;
    }

    public String[] getCourseNames() {
        return courseNames;
    }

    public void printStudents(){
        for (Student student:studentList){
            System.out.println(student.getFullName());
        }
    }

    public String[] getStudentNames() {
        studentNames=new String[studentList.length];
        for (int i = 0; i <studentList.length ; i++) {
            studentNames[i]=studentList[i].getFullName();
        }
        return studentNames;
    }

    public void setStudentNames(String[] studentNames) {
        this.studentNames = studentNames;
    }

    public double countMeanGrade( String courseName) {
        int courseIndex = UniversityService.search(courseNames, courseName);
        if (courseIndex == -1) {
            return -1;
        }

        int quantity = studentList.length;
        double sum = 0;
        System.out.println(courseName);
        for (Student student : studentList) {
            System.out.println(student.getFullName() + "':  " + student.getCourseGrades()[courseIndex].getGrade());
            sum += student.getCourseGrades()[courseIndex].getGrade();
        }

        return Double.parseDouble(numberFormat.format(sum / quantity));
    }
}
