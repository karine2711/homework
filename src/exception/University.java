package exception;
/**
 * University is a singletone class, as the program is written for a specific university.
 * It contains the list of faculties and the list of students in the university, as well
 * some methods to work with those lists.
 *
 * @author Karine Gevorgyan
 */
public class University {

    private static final University UNIVERSITY=new University(new Faculty[]{new Faculty("CS"), new Faculty("EC")});
    private Faculty[] facultyList;

    private University(Faculty[] faculties) {
        if(faculties.length==0){
            System.out.println("Error! The university must have at least one faculty!");
        }else {
            facultyList = faculties;
        }
    }

    public static University getUniversity(String...faculties){
        return UNIVERSITY;
    }

    public Faculty[] getFacultyList() {
        return facultyList;
    }
}
