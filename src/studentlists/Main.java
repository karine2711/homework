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

}
