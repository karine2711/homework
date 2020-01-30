package mapandenam;

import mapandenam.task1.Faculty;
import mapandenam.task1.Student;
import mapandenam.task1.StudentService;

import java.util.List;

public class Main {
    public static final String SEPARATOR = "----------";

    public static void main(String[] args) {
        List<Student> studentList = StudentService.initStudentList();
        task1A(studentList);
        task1B(studentList);
    }

    public static void task1A(List<Student> studentList) {
        System.out.println(SEPARATOR + "TASK 1- A" + SEPARATOR);
        System.out.println("Count the number of occurrences for each first name and last name");
        System.out.println(StudentService.getStudentsMap(studentList));
    }

    public static void task1B(List<Student> studentList) {
        System.out.println(SEPARATOR + "TASK 1 - B" + SEPARATOR);
        System.out.println("Count the number of occurrences for each first name and last name");
        StudentService.countStudentsInEachFaculty(studentList);
        Faculty.print();
        System.out.println("The number of students in Math faculty is " + Faculty.MATH.getStudentQuantity());
    }

}
