package studentlists;

import studentlists.comparators.*;
import studentlists.customformations.CustomInitializer;
import studentlists.customformations.StudentDynamicArray;
import studentlists.customformations.StudentLinkedList;

import static studentlists.StudentService.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


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


        //make a linked list
        StudentLinkedList linkedList = new StudentLinkedList();
        linkedList.addLast(array.get(0));
        linkedList.addLast(array.get(1));
        linkedList.addLast(array.get(2));
        linkedList.addLast(array.get(3));
        linkedList.addLast(array.get(4));

        Iterator<Student> iterator = linkedList.iterator();

        while (iterator.hasNext()) {

            System.out.println(iterator.next().getFirstName());

        }
        System.out.println("------------");
        System.out.println(linkedList.removeLast().getFirstName());
        System.out.println(linkedList.removeLast().getFirstName());
        System.out.println(linkedList.removeLast().getFirstName());
        System.out.println(linkedList.removeLast().getFirstName());
        System.out.println(linkedList.removeLast().getFirstName());


    }


}
