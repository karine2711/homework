package studentlists;

import studentlists.comparators.*;
import studentlists.customformations.CustomInitializer;
import studentlists.customformations.StudentDynamicArray;
import studentlists.customformations.StudentLinkedList;

import static studentlists.StudentService.*;

import java.util.*;


public class Main {
    private static final String SEPERATOR="--------------------";

    public static void main(String[] args) {

        //task1
        List<Student> studentArrayList = initializeStudents();
        printDoubleSortedList(studentArrayList,new StudentSorterByAge(), new StudentSorterByFirstName());


    }

    public static void printDoubleSortedList(List list, Comparator comparator1,
                                       Comparator comparator2){
        System.out.println(SEPERATOR+"Initial List"+SEPERATOR);
        printStudentShortInfo(list);
        Collections.sort(list, new StudentSorterByFirstName().thenComparing(new StudentSorterByAge().reversed()));
        System.out.println(SEPERATOR+"Sorted by name(asc) and then by age(desc)"+SEPERATOR);
        printStudentShortInfo(list);

    }

}
