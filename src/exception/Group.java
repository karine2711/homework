package exception;
/**
 * The Group class represents the groups in each faculty of the University.
 * Contains lists of courses and students.
 *
 *
 * @author Karine Gevorgyan
 */
public class Group {
    private char name;
    private String courseNames[];
    public Student[] studentList;
    private  int studentQuantity=0;

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
}
