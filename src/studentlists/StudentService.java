package studentlists;

import java.util.List;

/**
 * Provides methods to work with student objects and lists
 */
public class StudentService {

    public static void printStudentShortInfo(List<Student> studentList) {
        for (Student student : studentList) {
            System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getAge());
        }
    }
}
