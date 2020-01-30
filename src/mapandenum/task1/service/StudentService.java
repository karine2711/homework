package mapandenum.task1.service;

import mapandenum.task1.enumerations.Faculty;
import mapandenum.task1.model.Student;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {

    //initialize a list of students
    public static List<Student> initStudentList() {

        List<Student> students = new ArrayList<>();

        //create some students and add them to the list if all arguments are legal
        try {
            Student student1 = new Student("Diana", "Asatryan", 22,
                    "098811111", Faculty.MATH);
            students.add(student1);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            Student student2 = new Student("Diana", "Asatryan", 32,
                    "0922111111", Faculty.PHYSICS);
            students.add(student2);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            Student student3 = new Student("Diana", "Asatryan", 21,
                    "0938111111", Faculty.PHILOSOPHY);
            students.add(student3);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            Student student4 = new Student("Karen", "Balayan", 12,
                    "097777777", Faculty.MATH);
            students.add(student4);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            Student student5 = new Student("Karen", "Balayan", 23,
                    "098888811", Faculty.PHILOSOPHY);
            students.add(student5);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            Student student6 = new Student("Elen", "Mirzoyan", 12,
                    "093333333", Faculty.ENGLISH);
            students.add(student6);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return students;

    }

    //Returns a map of students with the number of occurrences of the same first and last names
    public static Map<String, Integer> getStudentsMap(@NotNull List<Student> students) {

        Map<String, Integer> studentMap = new HashMap<>();
        for (Student student : students) {
            if (!studentMap.containsKey(student.getFullName())) {
                studentMap.put(student.getFullName(), 1);
            } else {
                int currentValue = studentMap.get(student.getFullName());
                currentValue++;
                studentMap.put(student.getFullName(), currentValue);
            }
        }
        return studentMap;

    }

    //Counts the number of students in each faculty and stores this info in Faculty enumeration
    public static void countStudentsInEachFaculty(@NotNull List<Student> students) {

        Faculty.resetStudentQuantity();
        for (Student student : students) {
            student.getFaculty().incrementStudentQuantity();
        }

    }

}
