package studentlists;

import studentlists.comparators.*;
import static studentlists.StudentService.*;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) {
        ArrayList<Student> studentArrayList = initializeStudentArrayList();
        printStudentShortInfo(studentArrayList);
    }

    public static ArrayList<Student> initializeStudentArrayList() {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("Emma", "Sharp", 25));
        studentArrayList.add(new Student("Anthony", "Evans", 18));
        studentArrayList.add(new Student("Rosie", "Bell", 17));
        studentArrayList.add(new Student("Harvey", "Drew", 23));
        studentArrayList.add(new Student("Emma", "Mccarthy", 37));
        studentArrayList.add(new Student("Cole", "Cooper", 20));
        studentArrayList.add(new Student("Isabel", "Griffin", 29));
        studentArrayList.add(new Student("Cole", "Shelton", 31));
        studentArrayList.add(new Student("Tommy", "Rodriguez", 16));
        return studentArrayList;
    }
}
