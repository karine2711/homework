package mapandenam;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = StudentService.initStudentList();
        System.out.println(StudentService.getStudentsMap(studentList));

    }
}
