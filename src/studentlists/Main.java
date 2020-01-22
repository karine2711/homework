package studentlists;

import studentlists.comparators.*;
import studentlists.customformations.CustomInitializer;
import studentlists.customformations.StudentDynamicArray;
import studentlists.customformations.StudentLinkedList;

import static studentlists.StudentService.*;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<Student> studentArrayList = initializeStudents();
        printStudentShortInfo(studentArrayList);
        Collections.sort(studentArrayList, new StudentSorterByFirstName().thenComparing(new StudentSorterByAge().reversed()));
        System.out.println("--------------------Sorted by name(asc) and then by age(desc)-----------------------------");
        printStudentShortInfo(studentArrayList);
        System.out.println("--------------------Dynamic array------------------");
        StudentDynamicArray array = CustomInitializer.getDynamicArray();
        CustomInitializer.printStudentDynamicArray();
        Student Harvey = StudentService.findStudent(array, "Harvey", "Drew");
        array.remove(Harvey);
        System.out.println("------After removing Harvey Drew--------");
        CustomInitializer.printStudentDynamicArray();

        System.out.println("\n------Linked list sorted by last name--------");
        LinkedList <Student> linkedList1=new LinkedList<Student>(studentArrayList);
        Collections.sort(linkedList1);
        for(Student student:linkedList1){
            System.out.println(student.getLastName()+" "+student.getFirstName());
        }

        //make a linked list
        StudentLinkedList linkedList = new StudentLinkedList();
        linkedList.push(array.get(0));
        linkedList.addLast(array.get(1));
        System.out.println(linkedList.size());
        linkedList.push(array.get(2));
        linkedList.addLast(array.get(3));
        linkedList.addLast(array.get(4));
        System.out.println(linkedList.size());
        Iterator<Student> iterator = linkedList.iterator();


        System.out.println("------------");
        System.out.println(linkedList.pop().getFirstName());
        System.out.println(linkedList.removeLast().getFirstName());
        System.out.println(linkedList.size());
        System.out.println(linkedList.removeLast().getFirstName());
        System.out.println(linkedList.pop().getFirstName());
        System.out.println(linkedList.size());
        System.out.println(linkedList.removeLast().getFirstName());
        System.out.println(linkedList.size());

    }


}
