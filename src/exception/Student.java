package exception;
/**
 * The Student class represents the students of the university.
 * Contains lists of courseGrades and relevant information about
 * the student.
 *
 * @author Karine Gevorgyan
 */
public class Student {
    private String fullName;
    private char groupName;
    private int facultyNumber;

    public Student(String fullName, int facultyNumber, char groupName){
        this.fullName=fullName;
        this.groupName=groupName;
        this.facultyNumber=facultyNumber;
    }

    public String getFullName(){return  fullName;}

    public int getFacultyNumber() {
        return facultyNumber;
    }

}
