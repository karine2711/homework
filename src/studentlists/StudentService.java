package studentlists;

import studentlists.customformations.StudentDynamicArray;

import java.util.ArrayList;
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

    public static ArrayList<Student> initializeStudentArrayList() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("Emma", "Sharp", 25));
        studentArrayList.add(new Student("Anthony", "Evans", 18));
        studentArrayList.add(new Student("Rosie", "Bell", 17));
        studentArrayList.add(new Student("Harvey", "Drew", 23));
        studentArrayList.add(new Student("Emma", "Mccarthy", 37));
        studentArrayList.add(new Student("Cole", "Cooper", 20));
        studentArrayList.add(new Student("Isabel", "Griffin", 29));
        studentArrayList.add(new Student("Cole", "Shelton", 31));
        studentArrayList.add(new Student("Tommy", "Rodriguez", 16));
        return studentArrayList;
    }


}
