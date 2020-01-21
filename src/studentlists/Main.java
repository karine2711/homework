package studentlists;

import studentlists.comparators.*;
import static studentlists.StudentService.*;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        ArrayList<Student> studentArrayList = initializeStudentArrayList();
        printStudentShortInfo(studentArrayList);
        Collections.sort(studentArrayList, new StudentSorterByFirstName().thenComparing(new StudentSorterByAge().reversed()));
        System.out.println("--------------------Sorted by name(asc) and then by age(desc)-----------------------------");
        printStudentShortInfo(studentArrayList);
    }


}
