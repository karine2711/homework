package studentlists;

import studentlists.comparators.*;
import studentlists.customformations.CustomInitializer;
import studentlists.customformations.StudentDynamicArray;

import static studentlists.StudentService.*;

import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        ArrayList<Student> studentArrayList = initializeStudents();
        printStudentShortInfo(studentArrayList);
        Collections.sort(studentArrayList, new StudentSorterByFirstName().thenComparing(new StudentSorterByAge().reversed()));
        System.out.println("--------------------Sorted by name(asc) and then by age(desc)-----------------------------");
        printStudentShortInfo(studentArrayList);
        System.out.println("--------------------Dynamic array------------------");
        CustomInitializer.initializeStudentDynamicArray();
        StudentDynamicArray array = CustomInitializer.getDynamicArray();
        printStudentShortInfo(array);
        Student student = StudentService.findStudent(array, "Harvey", "Drew");
        array.remove(student);
        System.out.println("------After removing Harvey Drew--------");
        printStudentShortInfo(array);
    }


}
