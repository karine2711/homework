package studentlists.customformations;

import studentlists.Student;
import studentlists.StudentService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomInitializer {
    private static StudentDynamicArray dynamicArray = new StudentDynamicArray();
    private static StudentLinkedList linkedList = new StudentLinkedList();

    public static StudentDynamicArray getDynamicArray() {
        return dynamicArray;
    }

    public static StudentLinkedList getLinkedList() {
        return linkedList;
    }

    public static void initializeStudentDynamicArray(List<Student> studentList) {
        for (Student student : studentList) {
            dynamicArray.add(student);
        }
    }

    public static void initializeStudentLinkedList(List <Student> studentList) {
        for (Student student : studentList) {
            linkedList.addLast(student);
        }
    }

    public static void printStudentDynamicArray() {
        int size = dynamicArray.size();

        if (size != 0) {
            for (int i = 0; i < size; i++) {
                Student student = dynamicArray.get(i);
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }
        } else {
            System.out.println("The student array you provided is null!");
        }
    }

}
