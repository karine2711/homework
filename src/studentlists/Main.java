package studentlists;

import studentlists.comparators.*;
import studentlists.customformations.CustomInitializer;
import studentlists.customformations.StudentDynamicArray;
import studentlists.customformations.StudentLinkedList;

import static studentlists.StudentService.*;

import java.util.*;


public class Main {
    private static final String SEPERATOR = "--------------------";

    public static void main(String[] args) {

        //task 1
        System.out.println(SEPERATOR + "TASK 1" + SEPERATOR);
        List<Student> studentArrayList = initializeStudents();
        printDoubleSortedList(studentArrayList, new StudentSorterByFirstName(), new StudentSorterByAge());

        //task 2
        System.out.println(SEPERATOR + "TASK 2" + SEPERATOR);
        List<Student> studentLinkedList = new LinkedList<>();
        studentLinkedList.addAll(studentArrayList);
        printSortedList(studentLinkedList);

        //task3
        System.out.println(SEPERATOR + "TASK 3" + SEPERATOR);
        StudentDynamicArray studentDynamicArray = new StudentDynamicArray();
        testStudentDynamicArray(studentDynamicArray);

    }

    public static void printDoubleSortedList(List list, Comparator comparator1,
                                             Comparator comparator2) {
        System.out.println(SEPERATOR + "Initial List" + SEPERATOR);
        printStudentShortInfo(list);
        Collections.sort(list, comparator1.thenComparing(comparator2.reversed()));
        System.out.println(SEPERATOR + "Sorted by name(asc) and then by age(desc)" + SEPERATOR);
        printStudentShortInfo(list);

    }

    public static void printSortedList(List list) {
        System.out.println(SEPERATOR + "Initial List" + SEPERATOR);
        printStudentShortInfo(list);
        Collections.sort(list);
        System.out.println(SEPERATOR + "Sorted by last name" + SEPERATOR);
        printStudentShortInfo(list);
    }

    public static void testStudentDynamicArray(StudentDynamicArray studentDynamicArray) {
        studentDynamicArray.add(new Student("Karine", "Gevorgyan", 18));
        studentDynamicArray.add(new Student("Anna", "Mkrtchyan", 20));
        System.out.println("Student [0] = " + studentDynamicArray.get(0).getFirstName());
        System.out.println("size = " + studentDynamicArray.size());
        Student Karine = StudentService.findStudent(studentDynamicArray, "Karine", "Gevorgyan");
        studentDynamicArray.remove(Karine);
        System.out.println(SEPERATOR + "After removing Karine" + SEPERATOR);
        System.out.println("Student [0] = " + studentDynamicArray.get(0).getFirstName());
        System.out.println("size = " + studentDynamicArray.size());
    }

}
