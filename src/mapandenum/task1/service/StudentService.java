package mapandenum.task1.service;

import mapandenum.task1.enumerations.Faculty;
import mapandenum.task1.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {

    //initialize a list of students
    public static List<Student> initStudentList() {

        List<Student> students = new ArrayList<>();

        // add some students to the list
        addStudentInList("Diana", "Asatryan", 22,
                "098811111", Faculty.MATH, students);
        addStudentInList("Diana", "Asatryan", 32,
                "0922111111", Faculty.PHYSICS, students);
        addStudentInList("Diana", "Asatryan", 21,
                "0938111111", Faculty.PHILOSOPHY, students);
        addStudentInList("Karen", "Balayan", 12,
                "097777777", Faculty.MATH, students);
        addStudentInList("Karen", "Balayan", 23,
                "098888811", Faculty.PHILOSOPHY, students);
        addStudentInList("Elen", "Mirzoyan", 12,
                "093333333", Faculty.ENGLISH, students);

        return students;

    }

    private static void addStudentInList(String name, String surname, int age, String phoneNumber,
                                         Faculty faculty, List<Student> students) {
        try {
            Student student = new Student(name, surname, age,
                    phoneNumber, faculty);
            students.add(student);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /*Returns a map of students with the number of occurrences of the same first and last names
    The keys of the map are first occurred students for each duplicate name
     */
    public static Map<Student, Integer> getStudentsMap(List<Student> students) {
        Map<Student, Integer> studentMap = new HashMap<>();
        Map<String, Student> nameStudent = new HashMap<>();
        for (Student student : students) {
            if (!nameStudent.containsKey(student.getFullName())) {
                nameStudent.put(student.getFullName(), student);
                studentMap.put(student, 1);
            } else {
                Student student1 = nameStudent.get(student.getFullName());
                int currentValue = studentMap.get(student1);
                currentValue++;
                studentMap.put(student1, currentValue);
            }
        }
        return studentMap;

    }

    //Counts the number of students in each faculty and stores this info in Faculty enumeration
    public static Map<Faculty, Integer> countStudentsInEachFaculty(List<Student> students) {
        Map<Faculty, Integer> numberOfStudentsInEachFaculty = new HashMap<>();
        for (Student student : students) {
            Faculty faculty = student.getFaculty();
            if (!numberOfStudentsInEachFaculty.containsKey(faculty)) {
                numberOfStudentsInEachFaculty.put(faculty, 1);
            } else {
                Integer quantity = numberOfStudentsInEachFaculty.get(faculty);
                quantity++;
                numberOfStudentsInEachFaculty.put(faculty, quantity);
            }
        }
        return numberOfStudentsInEachFaculty;
    }


}
