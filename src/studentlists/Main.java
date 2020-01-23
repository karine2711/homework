package studentlists;

import studentlists.comparators.*;
import studentlists.customformations.*;
import studentlists.exceptions.MissingInitializationException;

import static studentlists.StudentService.*;

import java.util.*;

/**
 * The main class of the program, which stores tester methods and
 * public static void main()
 */

public class Main {

    private static final String SEPERATOR = "--------------------";

    public static void main(String[] args) {

        task1();

        task2();

        task3();

        task4();

        task5();

    }

    //Prints the provided list, sorts it by comparator1, then by comparator2 and prints it again.
    public static void printDoubleSortedList(List<Student> list, Comparator<Student> comparator1,
                                             Comparator<Student> comparator2) {

        System.out.println(SEPERATOR + "Initial List" + SEPERATOR);
        printStudentShortInfo(list);
        Collections.sort(list, comparator1.thenComparing(comparator2.reversed()));
        System.out.println(SEPERATOR + "Sorted by name(asc) and then by age(desc)" + SEPERATOR);
        printStudentShortInfo(list);

    }

    //Sorts the provided Student list by last names(Student's comparable). Prints it before and after sort.
    public static void printSortedList(List<Student> list) {
        if (list == null) {
            throw new NullPointerException("The provided list is null!");
        }
        System.out.println(SEPERATOR + "Initial List" + SEPERATOR);
        printStudentShortInfo(list);
        Collections.sort(list);
        System.out.println(SEPERATOR + "Sorted by last name" + SEPERATOR);
        printStudentShortInfo(list);
    }

    //Calls all methods of StudentDynamicArray for testing purposes
    public static void testStudentDynamicArray(StudentDynamicArray studentDynamicArray) {
        if (studentDynamicArray == null) {
            throw new NullPointerException("The provided custom student dynamic array is null!");
        }
        studentDynamicArray.add(new Student("Karine", "Gevorgyan", 18));
        studentDynamicArray.add(new Student("Anna", "Mkrtchyan", 20));
        try {
            System.out.println("Student [0] = " + studentDynamicArray.get(0).getFirstName());
            System.out.println("size = " + studentDynamicArray.size());
            Student karine = StudentService.findStudent(studentDynamicArray, "Karine", "Gevorgyan");
            studentDynamicArray.remove(karine);
            System.out.println(SEPERATOR + "After removing Karine" + SEPERATOR);
            System.out.println("Student [0] = " + studentDynamicArray.get(0).getFirstName());
            System.out.println("size = " + studentDynamicArray.size());
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    //Calls all methods of StudentLinkedList for testing purposes
    public static void testStudentLinkedList(StudentLinkedList studentLinkedList) {
        if (studentLinkedList == null) {
            throw new NullPointerException("The provided custom student linked list is null!");
        }
        studentLinkedList.addLast(new Student("Laura", "Zohrabyan", 18));
        studentLinkedList.push(new Student("Anna", "Mkrtchyan", 20));
        studentLinkedList.push(new Student("Tigran", "Shamshyan", 19));
        try {
            System.out.println(studentLinkedList.size());
            System.out.println(studentLinkedList.removeLast().getFirstName());
            System.out.println(studentLinkedList.pop().getFirstName());
            System.out.println(studentLinkedList.size());
        } catch (NullPointerException e) {
            throw new NullPointerException("The provided custom student linked list is null!");
        }
    }

    //Calls all methods of CustomInitializer for testing purposes
    public static void testCustomInitializer(List<Student> studentArrayList) {
        if (studentArrayList == null) {
            throw new NullPointerException("The provided list is null!");
        }
        try {
            System.out.println(SEPERATOR + "Initialized Dynamic Array" + SEPERATOR);
            CustomInitializer.initializeStudentDynamicArray(studentArrayList);
            CustomInitializer.printStudentDynamicArray();
            System.out.println(SEPERATOR + "Initialized Linked List" + SEPERATOR);
            CustomInitializer.initializeStudentLinkedList(studentArrayList);
            CustomInitializer.printStudentLinkedList();
        } catch (MissingInitializationException e) {
            System.out.println(e.getMessage());
        }

    }

    //tasks

    public static void task1() {
        System.out.println(SEPERATOR + "TASK 1" + SEPERATOR);
        List<Student> studentArrayList = initializeStudents();
        try {
            printDoubleSortedList(studentArrayList, new StudentSorterByFirstName(), new StudentSorterByAge());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void task2() {
        System.out.println(SEPERATOR + "TASK 2" + SEPERATOR);
        try {
            List<Student> studentLinkedList = new LinkedList<>(initializeStudents());
            printSortedList(studentLinkedList);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void task3() {
        System.out.println(SEPERATOR + "TASK 3" + SEPERATOR);
        StudentDynamicArray studentDynamicArray = new StudentDynamicArray();
        try {
            testStudentDynamicArray(studentDynamicArray);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void task4() {
        System.out.println(SEPERATOR + "TASK 4" + SEPERATOR);
        StudentLinkedList customStudentLinkedList = new StudentLinkedList();
        try {
            testStudentLinkedList(customStudentLinkedList);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void task5() {
        System.out.println(SEPERATOR + "TASK 5" + SEPERATOR);
        try {
            testCustomInitializer(initializeStudents());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

}
