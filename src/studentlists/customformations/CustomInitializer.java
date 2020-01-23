package studentlists.customformations;

import studentlists.Student;
import studentlists.exceptions.MissingInitializationException;
import studentlists.exceptions.NullFormationException;

import java.util.Iterator;
import java.util.List;

/**
 * Initializes and stores custom formations of the program
 * Provides methods to access the stored formations and/or print them.
 */

public class CustomInitializer {
    private static StudentDynamicArray dynamicArray = new StudentDynamicArray();
    private static StudentLinkedList linkedList = new StudentLinkedList();

    //getters
    public static StudentDynamicArray getDynamicArray() {
        return dynamicArray;
    }

    public static StudentLinkedList getLinkedList() {
        return linkedList;
    }


    //initializers

    //Adds all elements of a list to a custom student dynamic array
    public static void initializeStudentDynamicArray(List<Student> studentList) {
        for (Student student : studentList) {
            dynamicArray.add(student);
        }
    }

    //Add all elements of a list to a custom student linked list
    public static void initializeStudentLinkedList(List<Student> studentList) {
        for (Student student : studentList) {
            linkedList.addLast(student);
        }
    }


    //printers

    //prints names and surnames of all students in the stored dynamic array
    public static void printStudentDynamicArray() {

        int size = dynamicArray.size();

        if (size != 0) {
            for (int i = 0; i < size; i++) {
                Student student = dynamicArray.get(i);
                System.out.println(student.getFirstName() + " " + student.getLastName());
            }
        } else {
            throw new MissingInitializationException("dynamic array");
        }

    }

    //prints names and surnames of all students in the stored linked list
    public static void printStudentLinkedList() {

        if (linkedList.size() == 0) {
            throw new MissingInitializationException("custom linked list");
        }

        Iterator<Student> iterator = linkedList.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println(student.getFirstName() + "  " + student.getLastName());
        }
    }

}
